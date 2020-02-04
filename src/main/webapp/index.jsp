<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<base href="<%=basePath%>">


<link rel="stylesheet" type="text/css" href="uploadTool/webuploader.css">
<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="uploadTool/webuploader.css">
<link rel="stylesheet" type="text/css" href="css/uploderStyle.css">

<title>大文件上传测试</title>
</head>
<body>

	<div id="uploader" class="wu-example">
		<!--用来存放文件信息-->
		<div id="thelist" class="uploader-list"></div>
		<div class="btns">
			<div id="picker">选择文件</div>
			<button id="ctlBtn" class="btn btn-default">开始上传</button>
		</div>
	</div>

	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="uploadTool/webuploader.min.js"></script>
	<script type="text/javascript">
	
		//初始化
		var chunkSize = 1 * 1024 * 1024;

		WebUploader.Uploader.register({
			'before-send-file' : 'beforeSendFile',
			'before-send' : 'beforeSend'
		}, {
			beforeSendFile : function(file) {
				console.log("beforeSendFile");
				// Deferred对象在钩子回掉函数中经常要用到，用来处理需要等待的异步操作。
				var task = new $.Deferred();
				// 根据文件内容来查询MD5
				uploader.md5File(file).progress(function(percentage) { // 及时显示进度
					console.log('计算md5进度:', percentage);
					getProgressBar(file, percentage, "MD5", "MD5");
				}).then(function(val) { // 完成
					console.log('md5 result:', val);
					file.md5 = val;
					// 模拟用户id
					// file.uid = new Date().getTime() + "_" + Math.random() * 100;
					file.uid = WebUploader.Base.guid();
					// 进行md5判断
					$.post("checkFileMd5", {
						uid : file.uid,
						md5 : file.md5
					}, function(data) {
						console.log(data.status);
						var status = data.status.value;
						task.resolve();
						if (status == 101) {
							// 文件不存在，那就正常流程
						} else if (status == 100) {
							// 忽略上传过程，直接标识上传成功；
							uploader.skipFile(file);
							file.pass = true;
						} else if (status == 102) {
							// 部分已经上传到服务器了，但是差几个模块。
							file.missChunks = data.data;
						}
					});
				});
				return $.when(task);
			},
			beforeSend : function(block) {
				console.log("block")
				var task = new $.Deferred();
				var file = block.file;
				var missChunks = file.missChunks;
				var blockChunk = block.chunk;
				console.log("当前分块：" + blockChunk);
				console.log("missChunks:" + missChunks);
				if (missChunks !== null && missChunks !== undefined
						&& missChunks !== '') {
					var flag = true;
					for (var i = 0; i < missChunks.length; i++) {
						if (blockChunk == missChunks[i]) {
							console.log(file.name + ":" + blockChunk
									+ ":还没上传，现在上传去吧。");
							flag = false;
							break;
						}
					}
					if (flag) {
						task.reject();
					} else {
						task.resolve();
					}
				} else {
					task.resolve();
				}
				return $.when(task);
			}
		});

		var uploader = WebUploader.create({

			// swf文件路径
			swf : 'uploadTool/Uploader.swf',

			// 文件接收服务端。
			server : 'http://localhost:8081/upload',

			// 选择文件的按钮。可选。
			// 内部根据当前运行是创建，可能是input元素，也可能是flash.
			pick : '#picker',
			fileVal : "file", //指明参数名称，后台也用这个参数接收文件
			//文件上传请求的参数表，每次发送都会发送此对象中的参数
			formData : {
				uid : 0,
				md5 : '',
				chunkSize : chunkSize
			},

			chunked : true, // 分块
			chunkSize : chunkSize, // 字节 1M分块
			threads : 3, //开启线程
			auto : false,

			// 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
			resize : false
		});

		/**
		 * 文件被添加进队列的时候
		 */
		uploader.on('fileQueued', function(file) {
			var $list = $('#thelist');
			var $li = $(' <li id="'+file.id+'">'
					+ '<div class= "wait state">等待上传</div>'
					+ '<span class="delete btn btn-danger">×</span>'
					+ '<img src="" alt="图片">' + '<p class="filename">'
					+ file.name + '</p>' + '</li>'), $img = $li.find('img');
			$list.append($li);
			//创建图片预览
			uploader.makeThumb(file, function(error, src) {
				if (error) {
					$img.replaceWith('<span>不支持格式,不能预览</span>');
					return;
				}
				$img.attr('src', src);
			});
		});

		//移除选择的图片
		$('#thelist').on('click', '.delete', function() {
			var fileId = $(this).parents('li').attr('id');
			if (confirm("确认移除此文件吗?")) {
				// 从上传队列中移除
				uploader.removeFile(fileId, true);
				// 从视图中移除缩略图
				$(this).parents('li').remove();
			}
		});

		// 文件上传过程中创建进度条实时显示。
		uploader.on('uploadProgress', function(file, percentage) {
			var $li = $('#' + file.id), $progress = $li.find('div.progress');
			// 避免重复创建
			if (!$progress.length) {
				$li.children('div.state').remove();
				$progress = $('<div class="progress state"></div>').appendTo(
						$li);
			}
			$progress.text('上传中');
		});

		// 文件上传成功处理。
		uploader.on('uploadSuccess', function(file, response) {
			var $li = $('#' + file.id), $success = $li.find('div.success');
			// 避免重复创建
			if (!$success.length) {
				$li.children('div.state').remove();
				$success = $('<div class="success"></div>').appendTo($li);
			}
			$success.text('上传成功');

		});

		//上传出错
		uploader.on('uploadError', function(file) {
			var $li = $('#' + file.id), $error = $li.find('div.error');
			// 避免重复创建
			if (!$error.length) {
				// 移除原来的
				$li.children('div.state').remove();
				// 创建新的状态进度条
				$error = $('<div class="error"></div>').appendTo($li);
			}
			$error.text('上传出错');
		});

		/**
		 * 确认上传
		 */
		$("#ctlBtn").on('click', function() {
			uploader.upload();
		})

		//当某个文件的分块在发送前触发，主要用来询问是否要添加附带参数，大文件在开起分片上传的前提下此事件可能会触发多次。
		uploader.onUploadBeforeSend = function(obj, data) {
			console.log("onUploadBeforeSend");
			var file = obj.file;
			data.md5 = file.md5 || '';
			data.uid = file.uid;
		};

		/**
		 *  生成进度条封装方法
		 * @param file 文件
		 * @param percentage 进度值
		 * @param id_Prefix id前缀
		 * @param titleName 标题名
		 */
		function getProgressBar(file, percentage, id_Prefix, titleName) {
			var $li = $('#' + file.id), $percent = $li.find('#' + id_Prefix
					+ '-progress-bar');
			// 避免重复创建
			if (!$percent.length) {
				$percent = $(
						'<div id="' + id_Prefix + '-progress" class="progress progress-striped active">'
								+ '<div id="'
								+ id_Prefix
								+ '-progress-bar" class="progress-bar" role="progressbar" style="width: 0%">'
								+ '</div>' + '</div>').appendTo($li).find(
						'#' + id_Prefix + '-progress-bar');
			}
			var progressPercentage = percentage * 100 + '%';
			$percent.css('width', progressPercentage);
			$percent.html(titleName + ':' + progressPercentage);
		}

		/**
		 * 隐藏进度条
		 * @param file 文件对象
		 * @param id_Prefix id前缀
		 */
		function fadeOutProgress(file, id_Prefix) {
			$('#' + file.id).find('#' + id_Prefix + '-progress').fadeOut();
		}
	</script>
</body>
</html>
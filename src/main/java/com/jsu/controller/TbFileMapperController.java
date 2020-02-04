package com.jsu.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsu.pojo.TbFile;
import com.jsu.pojo.TbFileMapper;
import com.jsu.service.TbFileMapperMapperService;
import com.jsu.service.TbFileMapperService;
import com.jsu.service.TbFileService;
import com.jsu.vo.Tree;
import com.jsu.vo.YunResult;

@Controller
public class TbFileMapperController {
	@Autowired
	private TbFileMapperService fileMapperService;
	@Autowired
	private TbFileMapperMapperService fileMapperMapperService;

	@Autowired
	private TbFileService fileService;

	/**
	 * 考虑在同一目录下面文件重名的情况
	 * 
	 * @param file
	 * @return
	 */
	public boolean Rename(TbFile file, Integer pId) {
		List<TbFile> files = fileMapperService.selectByPid(pId);
		int i;
		for (i = 0; i < files.size(); i++) {
			if ((files.get(i).getfName()).equals(file.getfName())) {
				return false;

			}
		}
		return true;

	}

	/**
	 * 查询用户登录之后的所有根目录
	 */
	@RequestMapping("/list")
	@ResponseBody
	public YunResult fileList(HttpServletRequest request, int fid) {

		/* 用户登录之后判断待处理 */
		int uId = Integer.parseInt(request.getAttribute("uid").toString());

		List<TbFile> listFile = fileMapperService.selectByUserId(uId, fid);
		return YunResult.success(listFile);

	}

	/**
	 * 当点击根目录之后所出来的子目录 只返回一层子目录
	 */
	@RequestMapping("/pidList")
	@ResponseBody
	public YunResult pidList(@RequestParam("fId") int fId) {
		List<TbFile> file = null;
		if (fId != 0) {
			file = fileMapperService.selectByFid(fId);
			if (file == null) {
				System.out.println("已经是根目录了！！！");
			}
			// return YunResult.success(file);

		}
		return YunResult.success(file);

	}

	/**
	 * 新建文件根据文件名以及pid新建
	 */
	@RequestMapping("/newDir")
	@ResponseBody
	public YunResult newDir(String fName, Integer pId, HttpServletRequest req) {
		System.out.println("新建文件夹： " + fName + "  " + pId);
		TbFile file = new TbFile();
		file.setfName(fName);
		file.setpId(pId);
		file.setfSize(0L);
		file.setuId(Integer.parseInt(req.getAttribute("uid").toString()));
		file.setIsDir(1);
		file.setfCreateTime(new Date());
		file.setfCate(10);
		/**
		 * 同目录下面的同名文件待处理
		 */
		if (Rename(file, pId)) {
			if (fileMapperService.insertSelective(file) > 0) {
				System.out.println("新建成功！！");
				return YunResult.success(file);
			} else {
				System.out.println("新建失败");
				return YunResult.error("新建失败");
			}

		} else {
			return YunResult.error("不能新建存在同名的文件");
		}

	}

	@RequestMapping("/rename")
	@ResponseBody
	public YunResult rename(int fid, String newName) {
		TbFile record = new TbFile();
		record.setfId(fid);
		record.setfName(newName);
		fileMapperService.updateByPrimaryKeySelective(record);
		return YunResult.success(true);
	}

	@RequestMapping("/remove")
	@ResponseBody
	public YunResult remove(@RequestParam("fId") int[] fId, @RequestParam("pId") int pId) {
		List<TbFile> files = new ArrayList<TbFile>();
		for (int i = 0; i < fId.length; i++) {
			TbFile file = fileMapperService.selectByPrimaryKey(fId[i]);
			files.add(file);
		}

		for (int i = 0; i < files.size(); i++) {
			// 把移动到新的目录里面根据同样考虑文件同名的情况
			files.get(i).setpId(pId);
			if (Rename(files.get(i), pId)) {
				if (fileMapperService.updateByPrimaryKeySelective(files.get(i)) > 0) {

					System.out.println("移动成功！！");
					// return YunResult.success(files.get(i));
				} else {
					System.out.println("移动失败");
					return YunResult.error("移动失败");
				}

			} else {
				return YunResult.error("移动地方存在同名的文件");
			}
		}
		return YunResult.success(files);

	}

	@RequestMapping("/copy")
	@ResponseBody
	public YunResult copy(@RequestParam("fId") int[] fId, @RequestParam("pId") int pId) {

		List<TbFile> tbFiles = new ArrayList<TbFile>();

		for (int i = 0; i < fId.length; i++) {
			// 查找fid下面的所有子目录
			List<TbFile> files = fileMapperService.selectByFid(fId[i]);
			// 查找要复制的文件
			TbFile file = fileMapperService.selectByPrimaryKey(fId[i]);
			// 设置要复制文件的Pid
			file.setpId(pId);
			file.setfId(null);
			// 同样考虑同一目录下面复制的重命名情况
			if (Rename(file, pId)) {
				// 复制文件
				fileMapperService.insertSelective(file);
				// 根据pId和fName找到记录的id

				TbFile file3 = fileMapperService.selectByPidName(file.getpId(), file.getfName());

				for (TbFile file2 : files) {
					// 复制文件下的子目录
					fileMapperService.insertSelective(file2);
				}
				System.out.println("复制成功！！");
				tbFiles.add(file3);
				// return YunResult.success(file3);

			} else {
				return YunResult.error("复制地方存在同名的文件");
			}

		}
		return YunResult.success(tbFiles);

	}

	@RequestMapping("download") // 匹配的是href中的download请求
	@ResponseBody
	public ResponseEntity<byte[]> download(HttpServletRequest request, @RequestParam("fid") Integer fid)
			throws IOException {
		System.out.println("------------进入下载 " + fid);
		// String
		// downloadFilePath="D:\\f4\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\F4_Cloudy\\upload";//从我们的上传文件夹中去取

		String downloadFilePath = request.getSession().getServletContext().getRealPath("/file");
		TbFile list = fileMapperService.selectByPrimaryKey(fid);
		String filename = list.getfName();
		// 获取文件映射路径
		TbFileMapper fileMapper = fileMapperMapperService.seectById(list.getmId());
		File file = new File(downloadFilePath + File.separator + fileMapper.getmPath());

		HttpHeaders headers = new HttpHeaders();// http头信息
		String downloadFileName = new String(filename.getBytes("UTF-8"), "iso-8859-1");// 设置编码
		headers.setContentDispositionFormData("attachment", downloadFileName);
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		// MediaType:互联网媒介类型 contentType：具体请求中的媒体类型信息

		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);

	}

	@RequestMapping("getDirTree")
	@ResponseBody
	public YunResult getDirTree(HttpServletRequest request) throws IOException {
		List<Tree> dirTree = fileService.getDirTree(Integer.parseInt(request.getAttribute("uid").toString()));
		return YunResult.success(dirTree);
	}

}

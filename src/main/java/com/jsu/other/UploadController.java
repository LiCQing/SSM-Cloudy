package com.jsu.other;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.jsu.pojo.TbFileMapper;
import com.jsu.service.TbFileMapperMapperService;
import com.jsu.vo.ResultStatus;
import com.jsu.vo.ResultVo;
import com.jsu.vo.YunResult;

@Controller
public class UploadController {
	
	
	
	@Autowired
	private StorageServiceImpl storageService;
	
	@Autowired 
	private TbFileMapperMapperService fileMapperService;
	
		@RequestMapping(value = "/upload")
	    @ResponseBody
	    public YunResult fileUpload(MultipartFileParam param, HttpServletRequest request) throws Exception  {
	        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
	        String path= request.getSession().getServletContext().getRealPath("/file");
	        System.out.println(param);
	        //param.setIdentifier(param.getIdentifier() + param.getFilename());
	        System.out.println("是否带有文件--》" +isMultipart);
	        if (isMultipart) {
	           // logger.info("上传文件start。");
	        	 System.out.println("--》上传文件");
	            try {
	               System.out.println(path);
	               //int uid = Integer.parseInt(request.getAttribute("uid").toString()) ;
	              storageService.uploadFileByMappedByteBuffer(param,path);
	            
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }else{ //分片查询
	        	//1.根据md5 查询是否存在
	        	//2.如果不存在，插入新记录，并且data中存储false, 调用service，创建config 和 test
	        	//3.如果存在，查看完成度
	        	//3.1如果已完成，返回skipUpload
	        	//3.2如果未完成，读取.conf 返回缺失的分片
	        	
	        	//System.out.println("分片检查");
	        	String resPoseText ="";
	        	
	        	TbFileMapper fileMapper = storageService.checkMd5(param.getIdentifier());
	        	if(fileMapper != null){ //存在
	        		System.out.println("文件也存在");
	        		if(fileMapper.getmSatus() == 0 ){ //未上传完成
	        			String miss = storageService.getMissingChunks(param,path);
	        			resPoseText = "{\"skipUpload\":false,\"has\":true,\"missChunk\":[" +miss+ "]}";
	        		}else{
	        			System.out.println("文件存在--》秒传");
	        			storageService.addNewFile(param,fileMapper);
	        			resPoseText = "{\"skipUpload\":true}";
	        		}
	        	}else{  //不存在
	        		fileMapperService.insertTbflieMMapper(param,path);
					storageService.addNewFileRecod(param,path);
	        		resPoseText = "{\"skipUpload\":false,\"has\":false}";
	        	}	
	        	//resPoseText
	        	return YunResult.success(resPoseText);
	        	
	        }
	        return YunResult.success(true);
	    }
	
	
	
	}
	
	
	
	

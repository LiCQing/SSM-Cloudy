package com.jsu.other;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jsu.service.TbFileService;


@Controller
public class zipController {
    @Autowired
    private TbFileService fileService;
    
	
	/**
	 *文件压缩下载
	 *billname:文件名
	 *filename：文件存放路径
	 */
	 @RequestMapping(value="downloacbat")
	 public void zipfileDownload_workerCard(Integer[] fid,String fileName,HttpServletRequest request, HttpServletResponse response) throws Exception{  
		
		 	if(fileName == null || fileName == ""){
		 		fileName = "批量下载";
		 	}
		 	
		    //响应头的设置
	        response.reset();
	        response.setCharacterEncoding("utf-8");
	        response.setContentType("multipart/form-data");
	       
	        //设置压缩包的名字
	        //解决不同浏览器压缩包名字含有中文时乱码的问题           
	        
	        String downloadName = fileName+".zip";
	        //返回客户端浏览器的版本号、类型
	        String agent = request.getHeader("USER-AGENT");  
	        try {
	        	//针对IE或者以IE为内核的浏览器：  
	            if (agent.contains("MSIE")||agent.contains("Trident")) {
	                downloadName = java.net.URLEncoder.encode(downloadName, "UTF-8");
	            } else {
	            	//非IE浏览器的处理：
	                //downloadName = new String(downloadName.getBytes("UTF-8"),"ISO-8859-1");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        response.setHeader("Content-Disposition", "attachment;fileName=\"" + downloadName + "\"");

	        //设置压缩流：直接写入response，实现边边压缩下载
	        ZipOutputStream zipos = null;
	        try {
	            zipos = new ZipOutputStream(new BufferedOutputStream(response.getOutputStream()));
	            zipos.setMethod(ZipOutputStream.DEFLATED); //设置压缩方法 
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        //循环将文件写入压缩流
	        DataOutputStream os = null;
	       
			
			//获取真实路径文件名 包括子文件/文件夹
			
			Map<String,String> allfilename=fileService.getFileTruthName(fid); 
			
			//从数据库中取出要下载的图片路径、并循环写入压缩
			
			String modipath = request.getSession().getServletContext().getRealPath("/file");
	        for (String key : allfilename.keySet()) {
	        		
	        		File file = new File(modipath ,allfilename.get(key));
	        		System.out.println(file.getAbsolutePath());
	        		if(file.exists()){
	        			try {
	        				//添加ZipEntry，并ZipEntry中写入文件流
	        				//这里，加上i是防止要下载的文件有重名的导致下载失败
	        				//文件名
	        				zipos.putNextEntry(new ZipEntry(key));
	        				os = new DataOutputStream(zipos);
	        				InputStream is = new FileInputStream(file);
	        				byte[] b = new byte[100];
	        				int length = 0;
	        				while((length = is.read(b))!= -1){
	        					os.write(b, 0, length);
	        				}
	        				is.close();
	        				zipos.closeEntry();
	        			} catch (IOException e) {
	        				e.printStackTrace();
	        			} 
	        		}
	    	}
	      
		     //关闭流
	        try {
	        	if(os!= null ){
	        		os.flush();
	 	            os.close();
	        	}
	            if(zipos!=null)
	            	zipos.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }  
	        
			//return "index";
	 }  
}

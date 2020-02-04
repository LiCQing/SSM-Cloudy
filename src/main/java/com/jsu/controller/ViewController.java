package com.jsu.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jsu.pojo.TbFileMapper;
import com.jsu.service.TbFileService;
import com.jsu.util.ToPDFConverter;

@Controller
public class ViewController {
	@Autowired
	private TbFileService fileService;
	
	//viewpdf
	@RequestMapping("/viewpdf/{fid}")	
	public void viewPdf(@PathVariable Integer fid,HttpServletRequest request,HttpServletResponse response) throws IOException{
		TbFileMapper fileMapper = fileService.getFileById(fid);
		String realPath = request.getSession().getServletContext().getRealPath("/file");
		realPath  = realPath +"\\"+ fileMapper.getmPath();
		System.out.println(realPath);
		if(fileMapper.getmMd5().equals("1")){
			realPath = ToPDFConverter.doc2pdf(realPath);
		}
		
		System.out.println(realPath);
		File file = new File(realPath);
		byte[] data = new byte[1024];
		int len = -1;
		
		try{
			FileInputStream input = new FileInputStream(file);
			ServletOutputStream out = response.getOutputStream();
			while( (len = input.read(data)) > 0 ){
				out.write(data,0,len);  //2f9396e811c11fec7bb5dd9b53ca1eff20190904200936
			}
			input.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}

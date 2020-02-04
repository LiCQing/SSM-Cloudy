package com.jsu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsu.pojo.TbFile;
import com.jsu.util.ToPDFConverter;
import com.jsu.vo.YunResult;

/*
 * json 返回示例
 */
@Controller
public class AjaxTest {
	
	@RequestMapping("/test")
	@ResponseBody
	public YunResult test(){
		
		return YunResult.success(new TbFile());
	}
	
	@RequestMapping("/show")
	@ResponseBody
	public String  TestShow(){
		String pdfPath = ToPDFConverter.doc2pdf("C:\\Users\\!N\\Desktop\\No.5\\《软件工程》实验3-类的分析与设计 --077.doc");
		System.out.println(pdfPath);
		return pdfPath;
	}
	
	

}

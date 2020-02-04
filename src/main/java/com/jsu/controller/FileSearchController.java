package com.jsu.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsu.pojo.TbFile;
import com.jsu.service.TbFileMapperService;

import com.jsu.vo.YunResult;

@Controller
public class FileSearchController {
	@Autowired
	TbFileMapperService   fileMapperService;
	
	@RequestMapping("search")
	@ResponseBody
	public  YunResult searchFile(String keyword){
		System.out.println("模糊查询");
		/*try {
			keyword = new String(keyword.getBytes("iso-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}*/
		System.out.println(keyword);
		List<TbFile> pageResult=fileMapperService.searchByfileName(keyword);
		for(TbFile fl:pageResult){
			System.out.println(fl.getfName()+"=="+fl.getfSize());
		}
		
		return YunResult.success(pageResult);
		
		
	}
	
	//分类查询
	@RequestMapping("/cateList")
	@ResponseBody
	public YunResult  searchByType(int cate,HttpServletRequest request){
		System.out.println("分类查找");
	    int uid = Integer.parseInt(request.getAttribute("uid").toString());
		List<TbFile> pageResult=fileMapperService.searchByCate(cate,uid);
		return YunResult.success(pageResult);
		
	}

}

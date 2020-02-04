package com.jsu.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsu.pojo.TbFile;
import com.jsu.service.TbFileMapperService;
import com.jsu.vo.YunResult;
import com.mysql.fabric.xmlrpc.base.Array;

@Controller
public class DeleteController {
	@Autowired
	TbFileMapperService  fileMapperService;
	
	//删除文件
	@RequestMapping("deletefile")
	@ResponseBody
	public YunResult deleteFile(int[] fid){
		System.out.println("模糊查找");
		boolean data=fileMapperService.deleteFile(fid,-1);
		System.out.println(data);
		return YunResult.success(data);
	}
	
	//回收站文件
	@RequestMapping("rcycle")
	@ResponseBody
	public  YunResult  rcycle(HttpServletRequest request){
		int uid = Integer.parseInt(request.getAttribute("uid").toString()) ;
		List<TbFile>  fileList=fileMapperService.rcycleFileList(uid);
		return YunResult.success(fileList);
		
	}
	
	//回收站还原文件
	@RequestMapping("redaction")
	@ResponseBody
	public YunResult  reduction(int fid){
		System.out.println("还原文件");
		boolean data=fileMapperService.reduction(fid);
		return YunResult.success(data);
		
		
	}
	
	//多文件恢复
	@RequestMapping("redactionFiles")
	@ResponseBody
	public YunResult  fileListRudaction(int[] fid){
		System.out.println("多文件恢复");
		fileMapperService.filesList(fid);
		return  YunResult.success(true);
	}
	
	//物理删除
	@RequestMapping("truethDelete")
	@ResponseBody
	public YunResult deleteFileInRecord(int fid[]){
		fileMapperService.delelteRecord(fid);
		return YunResult.success(true);
	}
}

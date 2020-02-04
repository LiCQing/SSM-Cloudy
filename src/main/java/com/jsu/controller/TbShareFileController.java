package com.jsu.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsu.pojo.TbFile;
import com.jsu.pojo.TbShare;
import com.jsu.service.TbFileMapperService;
import com.jsu.service.TbShareMapperService;
import com.jsu.vo.YunResult;

@Controller
public class TbShareFileController {

	@Autowired
	private TbShareMapperService shareMapperService;
	@Autowired
	private TbFileMapperService fileMapperService;
	// 用户uId,分享sId

	@RequestMapping("/saveshare")
	@ResponseBody
	public YunResult shareFile(int[] fid,HttpServletRequest request) {
		Object object = request.getAttribute("uid");
		int uId = 1;
		if(object != null)
			uId = Integer.parseInt(object.toString()) ;
		
		
		TbShare record = new TbShare();
		String string = new String();
		int i = 0;
		for (; i < fid.length - 1; i++) {
			string += Integer.toString(fid[i]) + ",";
		}
		string += Integer.toString(fid[i]);
		record.setuId(uId);
		record.setsCreateTime(new Date());
		record.setsStatus(0);
		record.setsValidDay(7);
		record.setsContent(string);
		System.out.println(record);
		shareMapperService.insert(record);
		System.out.println(record);
		int sId = record.getsId();
		return YunResult.success(sId);
	}

	@RequestMapping("/lookshare")
	@ResponseBody
	public YunResult lookShareFile(@RequestParam("sid") int sId) {
		TbShare share= shareMapperService.selectByPrimaryKey(sId);
		 String string = share.getsContent();
		System.out.println("fid--字符串" + string);
		List<TbFile> files = new ArrayList<TbFile>();
		for (String string2 : string.split(","))
		{
			TbFile file = fileMapperService.selectByPrimaryKey(Integer.parseInt(string2));
			files.add(file);
		}
      Map<String,Object> map = new HashMap<>();
      map.put("share", share);
      map.put("list", files);
	return YunResult.success(map);
	}

	@RequestMapping("/cancelshare")
	@ResponseBody
	public YunResult cancelShareFile(@RequestParam("sid") int[] sid) {
		
		for (int i : sid) {
			TbShare record = new TbShare();
			record.setsId(i);
			record.setsStatus(-1);
			shareMapperService.updateByPrimaryKeySelective(record );
		}
		
		/*int i = 0;
		for (; i < fId.length; i++) {
			int t = shareMapperService.updateByFid(shareMapperService.selectByPrimaryKey(fId[i]).getsId());
			if (t < 0)
				break;
		}
		if (i == fId.length) {
			return YunResult.success("取消分享成功");
		} else {
			return YunResult.error("取消分享失败");
		}*/
		return YunResult.success(true);
	}
	
	@RequestMapping("/selectAllShare")
	@ResponseBody
	public YunResult selectAllShare(HttpServletRequest request){
		
		int uId = 1;
		uId =Integer.parseInt(request.getAttribute("uid").toString()) ;
		List<TbShare> list = shareMapperService.selectByAll(uId);
		return YunResult.success(list);
		
		
		
	}
	
	
}

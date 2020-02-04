package com.jsu.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsu.dao.TbFileMapper;
import com.jsu.dao.TbShareMapper;
import com.jsu.pojo.TbFile;
import com.jsu.pojo.TbShare;
import com.jsu.pojo.TbShareExample;
@Service
public class TbShareMapperService {
	@Autowired
	private TbShareMapper tbShareMapper;
	
	@Autowired
	private TbFileMapper fileMapper;
	
   //记录条数
   public int countByExample(TbShareExample example){
	return tbShareMapper.countByExample(example);
   }
   //根据example删除记录
   public int deleteByExample(TbShareExample example){
	   return tbShareMapper.deleteByExample(example);
   }
   //根据id删除记录
   public int deleteByPrimaryKey(Integer sId){
	   return tbShareMapper.deleteByPrimaryKey(sId);
   }
   //插入记录
   public int insert(TbShare record){
	   return tbShareMapper.insertSelective(record);
   }
   //判断是否为空
   public int insertSelective(TbShare record){
	   return tbShareMapper.insertSelective(record);
   }
   //根据example查询记录
   public List<TbShare> selectByExample(TbShareExample example){
	   return tbShareMapper.selectByExample(example);
   }
   //根据id查询记录
   public TbShare selectByPrimaryKey(Integer sId){
	   return tbShareMapper.selectByPrimaryKey(sId);
   }
   //修改记录
   public int updateByExampleSelective(@Param("record") TbShare record, @Param("example") TbShareExample example){
	   return tbShareMapper.updateByExampleSelective(record, example);
   }
   //修改记录
   public int updateByExample(@Param("record") TbShare record, @Param("example") TbShareExample example){
	   return tbShareMapper.updateByExample(record, example);
   }
   //修改记录
   public int updateByPrimaryKeySelective(TbShare record){
	   return tbShareMapper.updateByPrimaryKeySelective(record);
   }
   //修改记录
   public int updateByPrimaryKey(TbShare record){
	   return tbShareMapper.updateByPrimaryKey(record);
   }
   //按照文件id修改分享状态
   public int updateByFid(int sId){
	   return tbShareMapper.updateByFid(sId);
   }
   //查找用户分享的记录
   public List<TbShare> selectByAll(int uId){
	   List<TbShare> list = tbShareMapper.selectByAll(uId);
	   list = list == null? new ArrayList():list;
	   for (TbShare tbShare : list) {
		   String content = tbShare.getsContent();
		   String[] split = content.split(",");
		   if(split.length  >0 ){
			  TbFile tbFile = fileMapper.selectByPrimaryKey(Integer.parseInt(split[0]));
			  String name;
			  if(tbFile == null || tbShare.getsStatus() != 0){
				  name ="分享已取消";
			  }else{
				name =tbFile.getfName()+ " 等"+  split.length + "个文件"  ;
			  }
			  
			  tbShare.setfName(name );
		   }else{
			   tbShare.setfName("未命名");
		   }
		   
		   
	   }
	   return  list;
   }

}

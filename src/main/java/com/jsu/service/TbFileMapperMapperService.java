package com.jsu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsu.dao.TbFileMapperMapper;
import com.jsu.other.MultipartFileParam;
import com.jsu.pojo.TbFileMapper;
import com.jsu.pojo.TbFileMapperExample;
import com.jsu.pojo.TbFileMapperExample.Criteria;

@Service
public class TbFileMapperMapperService {
   @Autowired
	 TbFileMapperMapper fileMapperMapper;
   /**
    * 插入一条信息特征码MD5
 * @param param 
    * @param expample
    * @return
    */
   public  int  insertTbflieMMapper(MultipartFileParam param,String basePath){
	   TbFileMapper expample = new TbFileMapper();
	   expample.setmMd5(param.getIdentifier());
	   String filename = param.getFilename();
	   expample.setmPath(param.getIdentifier() + filename.substring(filename.lastIndexOf('.')));
	   expample.setmSize(param.getTotalSize());
	   return fileMapperMapper.insertSelective(expample);
   }

   /**
    * 删除MD5的特征码
    * @param mid
    * @return
    */
   public  int deleteTbFileMMapperById(int mid){
	   return  fileMapperMapper.deleteByPrimaryKey(mid);
   }
   
  
   /**
    * 更新一个MD5
    * @param expample
    * @return
    */
   public int  updateTbMMapperById(TbFileMapper expample){
	   return  fileMapperMapper.updateByPrimaryKeySelective(expample);
   }
   /**
    * 查询所有的MD5信息
    * @param expample
    * @return
    */
   public List<TbFileMapper>  tbMMapperList(TbFileMapperExample expample){
	   return fileMapperMapper.selectByExample(expample);
   }
   
   /**
    * 按主键查找一条MD5的信息
    * @param mid
    * @return
    */
   public TbFileMapper tbMMapperById(int mid){
	   return fileMapperMapper.selectByPrimaryKey(mid);
	   
   }
   
   /**
    * 查找所有的映射数据
    * @return
    */
   public List<TbFileMapper>selectTbFileMapper(){
	   return fileMapperMapper.selectTbFileMapper();
   }

   /**
    * 根据id获取文件的真实路径
    * @param getmId
    * @return
    */
public TbFileMapper seectById(Integer id) {
	return fileMapperMapper.selectByPrimaryKey(id);
}

}

package com.jsu.dao;

import com.jsu.pojo.TbFile;
import com.jsu.pojo.TbFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbFileMapper {
    int countByExample(TbFileExample example);

    int deleteByExample(TbFileExample example);

    int deleteByPrimaryKey(Integer fId);

    int insert(TbFile record);

    int insertSelective(TbFile record);

    List<TbFile> selectByExample(TbFileExample example);
    
    List<TbFile> selectByUserId(Integer uId,Integer pId);
  
    List<TbFile> selectByPid(Integer pId);
    
    List<TbFile>  selectByFid(Integer fId);
    
    int  updateAuditMember(List<Integer> fid);
    

    TbFile selectByPrimaryKey(Integer fId);
    
    TbFile selectByPidName(int pId,String fNmae);
    

    int updateByExampleSelective(@Param("record") TbFile record, @Param("example") TbFileExample example);

    int updateByExample(@Param("record") TbFile record, @Param("example") TbFileExample example);

    int updateByPrimaryKeySelective(TbFile record);

    int updateByPrimaryKey(TbFile record);
}
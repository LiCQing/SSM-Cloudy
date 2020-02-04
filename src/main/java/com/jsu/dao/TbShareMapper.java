package com.jsu.dao;

import com.jsu.pojo.TbShare;
import com.jsu.pojo.TbShareExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbShareMapper {
    int countByExample(TbShareExample example);

    int deleteByExample(TbShareExample example);

    int deleteByPrimaryKey(Integer sId);

    int insert(TbShare record);

    int insertSelective(TbShare record);

    List<TbShare> selectByExample(TbShareExample example);

    TbShare selectByPrimaryKey(Integer sId);

    int updateByExampleSelective(@Param("record") TbShare record, @Param("example") TbShareExample example);

    int updateByExample(@Param("record") TbShare record, @Param("example") TbShareExample example);

    int updateByPrimaryKeySelective(TbShare record);

    int updateByPrimaryKey(TbShare record);
    
    int updateByFid(int sId);
    
    List<TbShare> selectByAll(int uId);
}
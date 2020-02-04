package com.jsu.dao;

import com.jsu.pojo.TbFileMapper;
import com.jsu.pojo.TbFileMapperExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbFileMapperMapper {
    int countByExample(TbFileMapperExample example);

    int deleteByExample(TbFileMapperExample example);

    int deleteByPrimaryKey(Integer mId);

    int insert(TbFileMapper record);

    int insertSelective(TbFileMapper record);

    List<TbFileMapper> selectByExample(TbFileMapperExample example);

    TbFileMapper selectByPrimaryKey(Integer mId);

    int updateByExampleSelective(@Param("record") TbFileMapper record, @Param("example") TbFileMapperExample example);

    int updateByExample(@Param("record") TbFileMapper record, @Param("example") TbFileMapperExample example);

    int updateByPrimaryKeySelective(TbFileMapper record);

    int updateByPrimaryKey(TbFileMapper record);
    
    List<TbFileMapper> selectTbFileMapper();
}
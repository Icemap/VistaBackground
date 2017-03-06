package com.wqz.vista.dao;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.wqz.vista.pojo.Proj;

@MapperScan
public interface ProjMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Proj record);

    int insertSelective(Proj record);

    Proj selectByPrimaryKey(Integer id);

    List<Proj> selectByBelong(Integer belong);
    
    int updateByPrimaryKeySelective(Proj record);

    int updateByPrimaryKey(Proj record);
   
}
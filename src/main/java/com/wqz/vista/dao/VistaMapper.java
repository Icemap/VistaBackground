package com.wqz.vista.dao;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.wqz.vista.pojo.Vista;

@MapperScan
public interface VistaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Vista record);

    int insertSelective(Vista record);

    Vista selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Vista record);

    int updateByPrimaryKey(Vista record);
    
    List<Vista> selectByBelong(Integer belong);
}
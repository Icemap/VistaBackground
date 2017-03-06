package com.wqz.vista.dao;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.wqz.vista.pojo.User;

@MapperScan
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    List<Integer> getIndexList();
}
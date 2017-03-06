package com.wqz.vista.dao;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.wqz.vista.pojo.Manager;

@MapperScan
public interface ManagerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Manager record);

    int insertSelective(Manager record);

    Manager selectByPrimaryKey(Integer id);
    
    Manager login(@Param(value="username")String username,
    		@Param(value="password")String password);

    int updateByPrimaryKeySelective(Manager record);

    int updateByPrimaryKey(Manager record);
    
    Integer selectByUsername(String username);
}
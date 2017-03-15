package com.wqz.vista.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wqz.vista.dao.UserMapper;
import com.wqz.vista.pojo.User;
import com.wqz.vista.service.UserService;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	UserMapper userMapper;
	
	public Boolean createUserRecord(User user)
	{
		return userMapper.insertSelective(user) == 1;
	}

	public List<Integer> getUserList()
	{
		return userMapper.selectIdList();
	}

	public User getById(Integer id)
	{
		return userMapper.selectByPrimaryKey(id);
	}
	
}

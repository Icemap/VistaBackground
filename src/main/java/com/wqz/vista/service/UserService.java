package com.wqz.vista.service;

import java.util.List;

import com.wqz.vista.pojo.User;

public interface UserService
{
	Boolean createUserRecord(User user);
	
	List<Integer> getUserList();
	
	User getById(Integer id);
}

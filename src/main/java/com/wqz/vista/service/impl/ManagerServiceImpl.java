package com.wqz.vista.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wqz.vista.dao.ManagerMapper;
import com.wqz.vista.pojo.Manager;
import com.wqz.vista.service.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService
{
	@Autowired
	ManagerMapper managerMapper;
	
	public Integer register(Manager manager)
	{
		if(isExist(manager.getUsername())) return -1;
		
		return managerMapper.insertSelective(manager);
	}

	public Manager login(String username, String password)
	{
		return managerMapper.login(username, password);
	}
	
	
	private Boolean isExist(String username)
	{
		return managerMapper.selectByUsername(username) != 0;
	}
}

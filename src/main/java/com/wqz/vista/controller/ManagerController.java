package com.wqz.vista.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wqz.vista.pojo.Manager;
import com.wqz.vista.service.impl.ManagerServiceImpl;

@Controller
@RequestMapping("/manager")
public class ManagerController
{
	@Autowired
	ManagerServiceImpl managerServiceImpl;
	
	@RequestMapping("/register")
	@ResponseBody
	public Object register(String name,String username,String password)
	{
		Manager manager = new Manager();
		manager.setName(name);
		manager.setUsername(username);
		manager.setPassword(password);
		
		return managerServiceImpl.register(manager);
	}
	
	@RequestMapping("/login")
	@ResponseBody
	public Object login(String username,String password)
	{
		return managerServiceImpl.login(username, password);
	}
}

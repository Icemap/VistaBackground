package com.wqz.vista.service;

import com.wqz.vista.pojo.Manager;

public interface ManagerService
{
	Integer register(Manager manager);
	Manager login(String username,String password);
	
}

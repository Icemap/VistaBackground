package com.wqz.vista.service;

import java.util.List;

import com.wqz.vista.pojo.Proj;

public interface ProjService
{
	Boolean createProj(Proj proj);
	
	List<Proj> selectProjByManagerId(Integer managerId);
	
	Boolean updateProjById(Proj proj);
	
	Boolean deleteProjById(Integer id);
}

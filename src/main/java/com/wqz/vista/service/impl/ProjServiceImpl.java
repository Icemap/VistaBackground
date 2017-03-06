package com.wqz.vista.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wqz.vista.dao.ProjMapper;
import com.wqz.vista.pojo.Proj;
import com.wqz.vista.service.ProjService;

@Service
public class ProjServiceImpl implements ProjService
{
	@Autowired
	ProjMapper projMapper;
	
	public Boolean createProj(Proj proj)
	{
		return projMapper.insertSelective(proj) == 1;
	}

	public List<Proj> selectProjByManagerId(Integer managerId)
	{
		return projMapper.selectByBelong(managerId);
	}

	public Boolean updateProjById(Proj proj)
	{
		return projMapper.updateByPrimaryKeySelective(proj) == 1;
	}

	public Boolean deleteProjById(Integer id)
	{
		return projMapper.deleteByPrimaryKey(id) == 1;
	}
}

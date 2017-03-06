package com.wqz.vista.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wqz.vista.dao.VistaMapper;
import com.wqz.vista.pojo.Vista;
import com.wqz.vista.service.VistaService;

@Service
public class VistaServiceImpl implements VistaService
{
	@Autowired
	VistaMapper vistaMapper;
	
	public Boolean createVista(Vista vista)
	{
		return vistaMapper.insertSelective(vista) == 1;
	}

	public List<Vista> getVistaByProjId(Integer projId)
	{
		return vistaMapper.selectByBelong(projId);
	}
}

package com.wqz.vista.service;

import java.util.List;

import com.wqz.vista.pojo.Vista;

public interface VistaService
{
	Boolean createVista(Vista vista);
	
	List<Vista> getVistaByProjId(Integer projId);
}

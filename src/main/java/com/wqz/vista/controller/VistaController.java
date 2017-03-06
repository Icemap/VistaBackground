package com.wqz.vista.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wqz.vista.pojo.Vista;
import com.wqz.vista.service.impl.VistaServiceImpl;

@Controller
@RequestMapping("/vista")
public class VistaController
{
	@Autowired
	VistaServiceImpl vistaServiceImpl;
	
	@RequestMapping("/create")
	@ResponseBody
	public Object create(String url,String content,Integer projId,Double lon,Double lat)
	{
		Vista vista = new Vista();
		vista.setUrl(url);
		vista.setContent(content);
		vista.setBelong(projId);
		vista.setLon(lon);
		vista.setLat(lat);
		
		return vistaServiceImpl.createVista(vista);
	}
	
	@RequestMapping("/selectByProjId")
	@ResponseBody
	public Object selectByProjId(Integer projId)
	{
		return vistaServiceImpl.getVistaByProjId(projId);
	}
}

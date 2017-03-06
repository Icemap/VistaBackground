package com.wqz.vista.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wqz.vista.pojo.Proj;
import com.wqz.vista.service.impl.ProjServiceImpl;

@Controller
@RequestMapping("/proj")
public class ProjController
{
	@Autowired
	ProjServiceImpl projServiceImpl;
	
	@RequestMapping("/create")
	@ResponseBody
	public Object create(String title,String content,Integer managerId)
	{
		Proj proj = new Proj();
		proj.setTitle(title);
		proj.setContent(content);
		proj.setBelong(managerId);
		
		return projServiceImpl.createProj(proj);
	}
	
	@RequestMapping("/selectByManagerId")
	@ResponseBody
	public Object selectByManagerId(Integer managerId)
	{
		return projServiceImpl.selectProjByManagerId(managerId);
	}
	
	@RequestMapping("/updateById")
	@ResponseBody
	public Object updateById(Integer id,String title,String content)
	{
		Proj proj = new Proj();
		proj.setId(id);
		proj.setTitle(title);
		proj.setContent(content);
		
		return projServiceImpl.updateProjById(proj);
	}
	
	@RequestMapping("/deleteById")
	@ResponseBody
	public Object deleteById(Integer id)
	{
		return projServiceImpl.deleteProjById(id);
	}
}

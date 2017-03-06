package com.wqz.vista.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.wqz.utils.Matrix2Rlt;
import com.wqz.vista.pojo.User;
import com.wqz.vista.pojo.Vista;
import com.wqz.vista.service.impl.UserServiceImpl;
import com.wqz.vista.service.impl.VistaServiceImpl;

@Controller
@RequestMapping("/user")
public class UserController
{
	@Autowired
	UserServiceImpl userServiceImpl;
	@Autowired
	VistaServiceImpl vistaServiceImpl;
	
	@RequestMapping("/create")
	@ResponseBody
	public Object create(Integer age,Integer income,String homeAddress,
			String workAddress,Integer projId,String vistaMatrix)
	{
		User user = new User();
		user.setAge(age);
		user.setIncome(income);
		user.setHomeaddress(homeAddress);
		user.setWorkaddress(workAddress);
		user.setProjid(projId);
		user.setVistamatrix(vistaMatrix);
		
		//�˴�ͨ�����������
		List<Vista> vl = vistaServiceImpl.getVistaByProjId(projId);
		StringBuilder rlt = new StringBuilder();
		for(int i = 0;i < vl.size();i++)
		{
			if(i != 0) rlt.append(":");
			rlt.append(vl.get(i).getId());
		}
		rlt.append(" = ");
		rlt.append(Matrix2Rlt.solve(vistaMatrix));
		
		user.setVistaresult(rlt.toString());
		
		return userServiceImpl.createUserRecord(user);
	}
	
	@RequestMapping("/get")
	@ResponseBody
	public void get(Integer userId,String callback, HttpServletResponse response) throws IOException
	{
		StringBuilder rlt = new StringBuilder();
		rlt.append(callback).append("(");
		rlt.append(new Gson().toJson(userServiceImpl.selectUserRecord(userId)));
		rlt.append(")");
		
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(rlt.toString());
	}
	
	@RequestMapping("/getIndexList")
	@ResponseBody
	public void getIndexList(String callback, HttpServletResponse response) throws IOException
	{
		StringBuilder rlt = new StringBuilder();
		rlt.append(callback).append("(");
		rlt.append(new Gson().toJson(userServiceImpl.getIndexList()));
		rlt.append(")");
		
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(rlt.toString());
	}
}

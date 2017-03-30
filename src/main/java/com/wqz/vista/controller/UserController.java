package com.wqz.vista.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.wqz.utils.Matrix2RltNew;
import com.wqz.vista.pojo.User;
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
	public Object create(String age,String income,String homeAddress,
			String workAddress,Integer projId,String vistaMatrix,String hold)
	{
		User user = new User();
		user.setAge(age);
		user.setIncome(income);
		user.setHomeaddress(homeAddress);
		user.setWorkaddress(workAddress);
		user.setProjid(projId);
		user.setVistamatrix(vistaMatrix);
		user.setHold(hold);
		
		//此处计算结果
		user.setVistaresult(Matrix2RltNew.solve(vistaMatrix));
		
		return userServiceImpl.createUserRecord(user);
	}
	
	@RequestMapping("/getUserIDList")
	public void getUserIDList(String callback,HttpServletResponse response) throws IOException
	{
        response.setContentType("application/json");  
        response.setCharacterEncoding("UTF-8");  
        PrintWriter writer=response.getWriter();  
        writer.println(callback+"("+new Gson().toJson(userServiceImpl.getUserList())+")");  
        writer.close();  
	}
	
	@RequestMapping("/getUser")
	public void getUser(Integer id,String callback,HttpServletResponse response) throws IOException
	{
		response.setContentType("application/json");  
        response.setCharacterEncoding("UTF-8");  
        PrintWriter writer=response.getWriter();  
        writer.println(callback+"("+new Gson().toJson(userServiceImpl.getById(id))+")");  
        writer.close(); 
	}
}

package com.wqz.vista.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public Object create(String age,String income,String homeAddress,
			String workAddress,Integer projId,String vistaMatrix)
	{
		User user = new User();
		user.setAge(age);
		user.setIncome(income);
		user.setHomeaddress(homeAddress);
		user.setWorkaddress(workAddress);
		user.setProjid(projId);
		user.setVistamatrix(vistaMatrix);
		
		//此处通过矩阵计算结果
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
}

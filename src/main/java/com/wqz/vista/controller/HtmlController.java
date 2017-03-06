package com.wqz.vista.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wqz.utils.HtmlUtils;

@Controller
@RequestMapping("/html")
public class HtmlController
{
	@RequestMapping(value = "/getVista")
	public void getVistaHtml(Double lon,Double lat, HttpServletResponse response) throws IOException
	{
		response.setContentType("text/html; charset=utf-8");
		
		String sHtml = "";
		try
		{
			sHtml = HtmlUtils.getHtml(lon, lat);
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		response.getWriter().write(sHtml.toString());
	}
}

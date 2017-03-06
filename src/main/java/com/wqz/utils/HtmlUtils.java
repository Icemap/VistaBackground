package com.wqz.utils;

import java.io.IOException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


public class HtmlUtils
{
	public static String getHtml(Double lon, Double lat) throws IOException
	{
		Resource fileRource = new ClassPathResource("vista.html");
		String htmlString = FileUtils.getText(fileRource.getFile());
		htmlString = htmlString.replace("#{lon}", lon + "");
		htmlString = htmlString.replace("#{lat}", lat + "");
	
		return htmlString;
	}
}

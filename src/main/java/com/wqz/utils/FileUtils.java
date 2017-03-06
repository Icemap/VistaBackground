package com.wqz.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class FileUtils
{
	public static String getText(File file)
	{
		StringBuilder result = new StringBuilder();
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(file));// ����һ��BufferedReader������ȡ�ļ�
			String s = null;
			while ((s = br.readLine()) != null)
			{// ʹ��readLine������һ�ζ�һ��
				result.append(System.lineSeparator() + s);
			}
			br.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return result.toString();
	}
}

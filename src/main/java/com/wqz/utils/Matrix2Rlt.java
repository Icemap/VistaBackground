package com.wqz.utils;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.wqz.vista.pojo.MatrixJsonBean;

public class Matrix2Rlt
{
	public static Double[][] Matrix2Arrays(String Matrix)
	{
		MatrixJsonBean[] ma = new Gson().fromJson(Matrix, MatrixJsonBean[].class);
		Integer num = (1 + (int)Math.round(Math.sqrt(1 + 8 * ma.length))) / 2;
		
		
		Double[][] MatrixArray = new Double[num][num];
		
		//¶Ô½ÇÏß
		for(int i = 0;i < MatrixArray.length; i++)
		{
			MatrixArray[i][i] = 1.0;
		}
		
		//¾ØÕó¸³Öµ
		int point = 0;
		for(int i = 0;i < MatrixArray.length - 1; i++)
		{
			for(int j = i + 1;j < MatrixArray.length; j++)
			{
				String[] index = ma[point].getValue().split(":");
				Double ratio = Integer.parseInt(index[0]) / Double.parseDouble(index[1]); 
				MatrixArray[i][j] = ratio;
				MatrixArray[j][i] = 1 / ratio;
				point++;
			}
		}
				
		return MatrixArray;
	}
	
	public static String solve(String Matrix)
	{
		Double[][] MatrixArray = Matrix2Arrays(Matrix);
		
		List<Double> itemsRatio = new ArrayList<Double>();
		
		Double totalSum = 0.0;
		for(Double[] array:MatrixArray)
		{
			Double itemsSum = 0.0;
			for(Double item:array)
			{
				itemsSum += item;
			}
			itemsRatio.add(itemsSum);
			totalSum += itemsSum;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i < itemsRatio.size();i++)
		{
			if(i != 0)
				sb.append(":");
			sb.append(itemsRatio.get(i) / totalSum);
		}
		
		return sb.toString();
	}
	
	public void Main()
	{
		Double[][] MatrixArray = Matrix2Arrays("[{\"index\":\"1:5\",\"value\":\"62:38\"},{\"index\":\"1:6\",\"value\":\"76:24\"},{\"index\":\"1:7\",\"value\":\"35:65\"},{\"index\":\"5:6\",\"value\":\"67:33\"},{\"index\":\"5:7\",\"value\":\"28:72\"},{\"index\":\"6:7\",\"value\":\"69:31\"}]");
		
		for(Double[] array:MatrixArray)
		{
			for(Double item:array)
			{
				item = (double)((int)(item * 100))/100;   
				System.out.print(item.toString() + "\t");
			}
			System.out.print("\n");
		}
	}
	
	
}

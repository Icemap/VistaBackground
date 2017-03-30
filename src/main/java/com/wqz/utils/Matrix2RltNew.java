package com.wqz.utils;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.wqz.vista.pojo.MatrixJsonBean;

public class Matrix2RltNew
{
	public static String solve(String Matrix)
	{
		MatrixJsonBean[] ma = new Gson().fromJson(Matrix, MatrixJsonBean[].class);
		List<String> indexList = new ArrayList<String>();
		List<Double> valueList = new ArrayList<Double>();
		
		Double nowValue = 1.0;
		Double totalValue = 1.0;
		
		indexList.add(ma[0].getIndex().split(":")[0]);
		valueList.add(nowValue);
		
		for(MatrixJsonBean m : ma)
		{
			nowValue = nowValue * 
					Double.parseDouble(m.getValue().split(":")[1]) / 
					Double.parseDouble(m.getValue().split(":")[0]);
			totalValue += nowValue;
			
			indexList.add(m.getIndex().split(":")[1]);
			valueList.add(nowValue);
		}
		
		StringBuilder indexSb = new StringBuilder();
		StringBuilder valueSb = new StringBuilder();
		for(int i = 0;i < indexList.size();i++)
		{
			if(i != 0)
			{
				indexSb.append(":");
				valueSb.append(":");
			}
			indexSb.append(indexList.get(i));
			valueSb.append((valueList.get(i) / totalValue) + "");
		}
		
		return indexSb.toString() + " = " + valueSb.toString();
	}
	
//	@Test
//	public void test()
//	{
//		String s = solve("[{\"index\":\"1:5\",\"value\":\"62:38\"},{\"index\":\"5:6\",\"value\":\"67:33\"},{\"index\":\"6:7\",\"value\":\"69:31\"}]");
//		
//		System.out.print(s);
//	}
}

package com.ownapitesting;

import org.testng.annotations.DataProvider;

public class DataProviderParent {
	@DataProvider(name="dataforpost")
	public Object[][] dataDrivenPost()
	{
//		Object[][] data=new Object[2][2];
//		data[0][0]="A105";
//		data[0][1]="suja";
//		data[1][0]="A106";
//		data[1][1]="priya";
		//return data;
		
		return new Object[][] {
			{"A107","kumar"},
			{"A108","sathish"}
		};
	}
	
	 @DataProvider(name="delEmp")
	 public Object[] deleteEmp()
	 {
		 return new Object[]{
				4,5,6
		 };
	 }
}

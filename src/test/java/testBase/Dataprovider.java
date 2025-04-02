package testBase;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import utilities.ExcelUtility;

public class Dataprovider {
	
	
	@DataProvider(name = "testdata")
	public String[][] data() throws IOException
	{
		
		String path =".\\testdata\\Opencart_LoginData.xlsx";
		
		ExcelUtility utility= new ExcelUtility(path);
		
		int rows =utility.getRowCount("sheet1");
		int coloums = utility.getCellCount("sheet1", 1);
		
		String datas [][]= new String[rows][coloums];
		
		
		
		for(int i=1; i<=rows;i++)
		{
			
			
			for(int j =0; j<coloums;j++)
			{
				datas[i-1][j] = utility.getCellData("sheet1", i, j);
			}
		}
		
		System.out.println("end");
		return datas;
	}

}

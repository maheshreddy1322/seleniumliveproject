package com.durgasoft.selenium.apachi.poi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadAllDataFromEntirerow {
  @Test
  public void f() throws Exception {
	  FileInputStream fis=new FileInputStream("D:\\images\\login.xlsx");
	  XSSFWorkbook w=new XSSFWorkbook(fis);
	  XSSFSheet s = w.getSheet("Sheet1");
       int rows = s.getLastRowNum();
	  System.out.print("Total number of rows are:"+rows);
	  for(int i=0;i<rows;i++)
	  {
		 String data = s.getRow(i).getCell(0).getStringCellValue();
		 System.out.println(data);
	  }
  }
}

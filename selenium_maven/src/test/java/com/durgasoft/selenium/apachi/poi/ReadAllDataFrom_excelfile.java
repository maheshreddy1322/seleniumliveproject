package com.durgasoft.selenium.apachi.poi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadAllDataFrom_excelfile {
	public FileInputStream fis;
	public XSSFWorkbook w;
	public XSSFSheet s;
	public XSSFRow row;
	public XSSFCell cell;
  @Test
  public void f() throws Exception {
	  fis=new FileInputStream("D:\\images\\login.xlsx");
	  w=new XSSFWorkbook(fis);
	  s=w.getSheet("Sheet1");
	 int rowcount = s.getLastRowNum()-s.getFirstRowNum();
	 System.out.println(rowcount);
	 for(int i=1;i<=rowcount;i++)
	 {
		 row=s.getRow(i);
		 for(int j=0;j<row.getLastCellNum();j++)
		 {
			 
			 System.out.println(row.getCell(j).getStringCellValue());
		 }
		 System.out.println();
	 }
  }
}

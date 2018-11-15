package com.durgasoft.selenium.apachi.poi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadDataFromExcelFIleByColumnname {
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
	  row=s.getRow(0);
	  cell=null;
	  int column=3;
	  for(int i=0;i<row.getLastCellNum();i++)
	  {
		  System.out.println(row.getCell(i).getStringCellValue());
		  if(row.getCell(i).getStringCellValue().equalsIgnoreCase("password"))
		  {
			  column=i;
			  System.out.println(column);
		  }
	  }
	  row=s.getRow(5);
	  cell=row.getCell(column);
	 String pwd = cell.getStringCellValue();
	  System.out.println(pwd);
  }
}

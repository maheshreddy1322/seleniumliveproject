package com.durgasoft.selenium.apachi.poi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class AddDataIntoExcelFileByUsingColumnName {
	public FileInputStream fis;
	public XSSFWorkbook w;
	public XSSFSheet s;
	public XSSFRow row;
	public XSSFCell cell;
	public FileOutputStream fos;
  @Test
  public void f() throws Exception {
	  fis=new FileInputStream("D:\\images\\login.xlsx");
	  w=new XSSFWorkbook(fis);
	  s=w.getSheet("Sheet1");
	  row=null;
	  cell=null;
	  int colnum=-1;
	  row=s.getRow(0);
	  for(int i=0;i<row.getLastCellNum();i++)
	  {
		  System.out.println(row.getCell(i).getStringCellValue());
		  if(row.getCell(i).getStringCellValue().equalsIgnoreCase("results"))
		  {
			  colnum=i;
			  
			 
		  }
	  }
	  
	  row=s.getRow(6);
	 if(row==null)
	  {
		  row=s.createRow(6);
	  }
	  cell=row.getCell(colnum);
	  if(cell==null)
	  {
		  cell=row.createCell(colnum);
	  }
	  cell.setCellValue("BLOCKED");
	  fos=new FileOutputStream("D:\\images\\login.xlsx");
	  w.write(fos);
	  fos.close();
  }
}

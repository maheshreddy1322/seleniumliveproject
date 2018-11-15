package com.durgasoft.selenium.apachi.poi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class WriteExcelDatabyIndex {
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
	  row=s.getRow(6);
			  if(row==null)
			  {
				  row=s.createRow(6);
			  }
						  cell=row.getCell(3);
			  
			  if(cell==null)
			  {
				 cell= row.createCell(3);
			  }
				 cell.setCellValue("FAILED");
				 fos=new FileOutputStream("D:\\images\\login.xlsx");
				 w.write(fos);
				 fos.close();
			  
  }
}

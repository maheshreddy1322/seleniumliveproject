package com.durgasoft.selenium.apachi.poi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class WriteExcelDataByUsingFontStyle {
	public FileInputStream fis;
	public XSSFWorkbook w;
	public XSSFSheet s;
	public XSSFRow row;
	public XSSFCell cell;
	public FileOutputStream fos;
	public XSSFFont font;
	public XSSFCellStyle style;
  @Test
  public void f() throws Exception {
	  fis=new FileInputStream("D:\\images\\login.xlsx");
	  w=new XSSFWorkbook(fis);
	  s=w.getSheet("Sheet1");
	  row=null;
	  cell=null;
	  font=w.createFont();
	  style=w.createCellStyle();
	  row=s.getRow(6);
	  if(row==null)
	  {
		  row=s.createRow(6);
	  }
	  cell=row.createCell(3);
	  if(cell==null)
	  {
		  cell=row.createCell(3);
	  }
	  font.setFontName("Arial Block");
	  font.setFontHeight(9);
	  font.setBold(true);
	  style.setFont(font);
	  cell.setCellStyle(style);
	  cell.setCellValue("skipped");
	  fos=new FileOutputStream("D:\\images\\login.xlsx");
	  w.write(fos);
	  fos.close();
  }
}

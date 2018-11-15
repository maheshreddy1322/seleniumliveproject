package com.durgasoft.selenium.apachi.poi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadDataFromExcelFile {
  @Test
  public void f() throws Exception {
	  FileInputStream fis=new FileInputStream("D:\\images\\login.xlsx");
	  XSSFWorkbook w=new XSSFWorkbook(fis);
	  XSSFSheet s = w.getSheet("Sheet1");
	 XSSFRow r = s.getRow(6);
	 XSSFCell cell = r.getCell(1);
	 System.out.println(cell.getStringCellValue());
	 w.close();
  }
}



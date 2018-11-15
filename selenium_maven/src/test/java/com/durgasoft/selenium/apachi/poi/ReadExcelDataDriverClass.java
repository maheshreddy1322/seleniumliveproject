package com.durgasoft.selenium.apachi.poi;

import org.testng.annotations.Test;

public class ReadExcelDataDriverClass {
  @Test
  public void f() throws Exception {
	  Excel_Api e=new Excel_Api("D:\\images\\login.xlsx");
	  System.out.println(e.getcelldata("Sheet1", 1, 6)); 
	  System.out.println(e.getcelldata("Sheet1", "results", 6)); 
	  System.out.println("-----------Read Data From Excel File-----------");
	  System.out.println(e.getcelldata("Sheet1", 0, 1));
	  System.out.println(e.getcelldata("Sheet1", 1, 1));
	  System.out.println(e.getcelldata("Sheet1", 2, 1));
	  System.out.println("--------------Read Data From Excel File By Using Column Name---------------");
	  System.out.println(e.getcelldata("Sheet1", "username", 1));
	  System.out.println(e.getcelldata("Sheet1", "password", 1));
	  System.out.println(e.getcelldata("Sheet1", "results", 1));
	  System.out.println(e.setcelldata("Sheet1", 2, 5, "passed"));
  }
}

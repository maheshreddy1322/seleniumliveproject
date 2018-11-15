package com.durgasoft.selenium.apachi.poi;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeTest;

public class Mapwithdataprovider {
  @Test(dataProvider = "testdata")
  public void test(Map<Object, Object> mapdata) {
	  System.out.println("---------------------test started---------------------");
	  System.out.println(mapdata.get("username"));
	  System.out.println(mapdata.get("password"));
	  System.out.println(mapdata.get("dob"));
	  System.out.println(mapdata.get("---------------------test end-------------------"));
  }

  @DataProvider(name="testdata")
  public Object[][] dataprovidermethod() throws Exception {
	  FileInputStream fis=new FileInputStream("D:\\images\\login.xlsx");
	  XSSFWorkbook w=new XSSFWorkbook(fis);
	 XSSFSheet sheet = w.getSheet("Sheet2");
	int rowcount = sheet.getLastRowNum();
	short colcount = sheet.getRow(0).getLastCellNum();
	Object[][] obj= new Object[rowcount][1];
	  for(int i=0;i<rowcount;i++)
	  {
		  HashMap<Object, Object> datamap=new HashMap<Object, Object>();
		  for(int j=0;j<colcount;j++)
		  {
			  datamap.put(sheet.getRow(0).getCell(j).toString(),sheet.getRow(i+1).getCell(j).toString() );
		  }
		  obj[i][0]=datamap;
	  }
	return obj;
 
  }
  @BeforeTest
  public void beforeTest() {
  }

}

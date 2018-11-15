package com.durgasoft.selenium.apachi.poi;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

public class Hms_Login_Logout_Excelapi1 {
	public WebDriver driver;
  @Test
  public void f() throws Exception {
	  Excel_Api e=new Excel_Api("D:\\images\\login.xlsx");
	 int numberofrows= e.getrows("Sheet1");
	 for(int i=0;i<numberofrows;i++)
	 {
		 driver.findElement(By.name("username")).clear();
		 driver.findElement(By.name("username")).sendKeys(e.getcelldata("Sheet1", 0, i));
		 Thread.sleep(5000);
	 }
  }
  @BeforeTest
  public void beforeTest() {
	  driver=new FirefoxDriver();
	  driver.get("http://seleniumbymahesh.com/HMS");
	  driver.manage().window().maximize();
	  
	  
  }

}

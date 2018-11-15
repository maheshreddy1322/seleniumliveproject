package com.durgasoft.selenium.testing;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

public class dateNtimescreenshot {
	public WebDriver driver;
  @Test
  public void f() throws Exception {
	  Date dt=new Date();
	  DateFormat dtformat=new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
	 File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 FileUtils.copyFile(src, new File("D:\\screenshots\\"+dtformat.format(dt)+"sbm.jpeg"));
  }
  @BeforeTest
  public void beforeTest() {
	  driver=new FirefoxDriver();
	  driver.get("http://newtours.demoaut.com/");
	  driver.manage().window().maximize();
	  
  }

}

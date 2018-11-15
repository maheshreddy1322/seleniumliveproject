package com.durgasoft.selenium.testing;

import org.testng.annotations.Test;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

public class Record_hms_application {
	public WebDriver driver;
	ATUTestRecorder recorder;
  @Test
  public void f() throws Exception {
	  driver.findElement(By.name("username")).sendKeys("admin");
	  driver.findElement(By.name("password")).sendKeys("admin");
	  driver.findElement(By.name("submit")).click();
	  Thread.sleep(5000);
	  driver.findElement(By.linkText("Logout")).click();
	  recorder.stop();
  }
  @BeforeTest
  public void beforeTest() throws Exception {
	  driver=new FirefoxDriver();
	  driver.get("http://seleniumbymahesh.com/HMS");
	   recorder=new ATUTestRecorder("D:\\recording", "hmslogin", false);
	  recorder.start();
	 
	  driver.manage().window().maximize();
  }

}

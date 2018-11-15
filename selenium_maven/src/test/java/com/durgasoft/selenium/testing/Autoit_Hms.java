package com.durgasoft.selenium.testing;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

public class Autoit_Hms {
	public WebDriver driver;
  @Test
  public void f() throws Exception {
	  driver.findElement(By.name("username")).sendKeys("admin");
	  driver.findElement(By.name("password")).sendKeys("admin");
	  driver.findElement(By.name("submit")).click();
	  driver.findElement(By.linkText("Registration")).click();
	  driver.findElement(By.linkText("Perminent Registration")).click();
	  driver.findElement(By.name("image")).click();
	  Runtime.getRuntime().exec("D:\\autoit\\upload.exe");
	  
  }
  @BeforeTest
  public void beforeTest() {
	  driver=new FirefoxDriver();
	  driver.get("http://seleniumbymahesh.com/HMS");
	  driver.manage().window().maximize();
  }

}

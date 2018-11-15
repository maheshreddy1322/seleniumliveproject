package com.durgasoft.selenium.testing;

import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

public class Scrolling_page {
	public WebDriver driver;
  @Test
  public void f() throws Exception {
	  Thread.sleep(5000);
	  JavascriptExecutor jse=(JavascriptExecutor)driver;
	  jse.executeScript("window.scrollBy(0,500)");
	  
  }
  @BeforeTest
  public void beforeTest() {
	  driver=new FirefoxDriver();
	  driver.get("http://seleniumbymahesh.com");
	  driver.manage().window().maximize();
	  
  }

}

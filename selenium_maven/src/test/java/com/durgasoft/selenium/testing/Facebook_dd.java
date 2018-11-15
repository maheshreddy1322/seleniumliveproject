package com.durgasoft.selenium.testing;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;

public class Facebook_dd {
	public WebDriver driver;
  @Test
  public void f() throws Exception {
	 // driver.findElement(By.id("month")).sendKeys("Sept");
	 WebElement ddmonth = driver.findElement(By.id("month"));
	Select monthdd = new Select(ddmonth);
	monthdd.selectByVisibleText("Sept");
	Thread.sleep(5000);
	monthdd.selectByIndex(3);
	Thread.sleep(4000);
	monthdd.selectByValue("12");
  }
  @BeforeTest
  public void beforeTest() {
	  driver=new FirefoxDriver();
	  driver.get("http://facebook.com");
	  driver.manage().window().maximize();
  }

}

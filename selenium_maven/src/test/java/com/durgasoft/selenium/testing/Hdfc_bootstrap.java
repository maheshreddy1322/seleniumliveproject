package com.durgasoft.selenium.testing;

import org.testng.annotations.Test;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

public class Hdfc_bootstrap {
	public WebDriver driver;
  @Test
  public void f() throws Exception {
	  driver.findElement(By.id("loginsubmit")).click();
	  Thread.sleep(5000);
	   Set<String> windows = driver.getWindowHandles();
	 Object[] s = windows.toArray();
	 System.out.println(s);
	 driver.switchTo().window(s[1].toString());
	 driver.findElement(By.xpath("(//a[@class='btn btn-default redBtn'])[2]")).click();
	 Thread.sleep(10000);
	 driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='login_page']")));
	 Thread.sleep(5000);
	 driver.findElement(By.xpath("//input[@class='input_password']")).sendKeys("mahesh123r");
	 
  }
  @BeforeTest
  public void beforeTest() {
	  driver=new FirefoxDriver();
	  driver.get("http://hdfcbank.com");
	  driver.manage().window().maximize();
	  
  }

}

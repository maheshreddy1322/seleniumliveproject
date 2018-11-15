package com.durgasoft.selenium.testing;

import org.testng.annotations.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

public class Explicitwait_in_python {
	public WebDriver driver;
  @Test
  public void f() throws Exception {
	  WebDriverWait wait=new WebDriverWait(driver, 120);
	  driver.findElement(By.id("lst-ib")).sendKeys("python tutorial");
	  Thread.sleep(5000);
	  List<WebElement> var = driver.findElements(By.xpath("//ul[@class='sbsb_b']/li/div/div[@class='sbqs_c']/b"));
	  for(int i=0;i<var.size();i++)
	  {
		  System.out.println(var.get(i).getAttribute("innerHTML"));
		  if(var.get(i).getAttribute("innerHTML").contains("point"))
		  {
			  wait.until(ExpectedConditions.elementToBeClickable(var.get(i))).click();
			  break;
		  }
	  }
  }
  @BeforeTest
  public void beforeTest() {
	  driver=new FirefoxDriver();
	  driver.get("http://google.com");
	  driver.manage().window().maximize();
	  
  }

}

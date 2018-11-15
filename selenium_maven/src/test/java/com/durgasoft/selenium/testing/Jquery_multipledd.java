package com.durgasoft.selenium.testing;

import org.testng.annotations.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

public class Jquery_multipledd {
	public WebDriver driver;
  @Test
  public void f() {
	  driver.findElement(By.xpath("//button[@class='multiselect dropdown-toggle btn btn-default']")).click();
	   WebElement header = driver.findElement(By.xpath("//ul[@class='multiselect-container dropdown-menu']"));
	   List<WebElement> ddvalues = header.findElements(By.tagName("input"));
	  System.out.println("Available values in dd are:"+ddvalues.size());
	  for(int i=0;i<ddvalues.size();i++)
	  {
		 if(ddvalues.get(i).getAttribute("value").equalsIgnoreCase("Bootstrap"))
		 {
			 ddvalues.get(i).click();
		 }
		 if(ddvalues.get(i).getAttribute("value").equalsIgnoreCase("HTML"))
		 {
			 ddvalues.get(i).click();
		 }
		 
	  }
		 
  }
  @BeforeTest
  public void beforeTest() {
	  driver=new FirefoxDriver();
	  driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_1");
	  driver.manage().window().maximize();
  }

}

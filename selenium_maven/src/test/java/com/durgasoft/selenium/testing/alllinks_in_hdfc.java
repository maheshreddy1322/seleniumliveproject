package com.durgasoft.selenium.testing;

import org.testng.annotations.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

public class alllinks_in_hdfc {
	public WebDriver driver;
  @Test
  public void f() {
	  int count=0;
	  List<WebElement> links = driver.findElements(By.tagName("a"));
	  System.out.println("the totla links in applications are:"+links.size());
	  for(int i=0;i<links.size();i++)
	  {
		  
		
		if(!links.get(i).getText().isEmpty())
		{
          count=count+1;
          String str = links.get(i).getText();
          System.out.println(str);
          links = driver.findElements(By.tagName("a"));
          
		}
			  
	  }
	  System.out.println("the total visible links are :"+count);
  }
  @BeforeTest
  public void beforeTest() {
	  driver=new FirefoxDriver();
	  driver.get("http://hdfcbank.com");
	  driver.manage().window().maximize();
  }

}

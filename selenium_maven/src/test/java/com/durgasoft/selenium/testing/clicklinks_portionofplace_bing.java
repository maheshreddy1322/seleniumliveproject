package com.durgasoft.selenium.testing;

import org.testng.annotations.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

public class clicklinks_portionofplace_bing {
	public WebDriver driver;
  @Test
  public void f() {
	 WebElement header = driver.findElement(By.id("sc_hdu"));
	List<WebElement> links = header.findElements(By.tagName("a"));
	System.out.println("available links are:"+links.size());
	for(int i=0;i<links.size();i++)
	{
		if(!links.get(i).getText().isEmpty())
		{
			if(links.get(i).getText().contentEquals("Maps"))
			{
				System.out.println("the link is available:"+links.get(i).getText());
				links.get(i).click();
				break;
			}
		}
	}
  }
  @BeforeTest
  public void beforeTest() {
	  driver=new FirefoxDriver();
	  driver.get("http://bing.com");
	  driver.manage().window().maximize();
	  
  }

}

package com.durgasoft.selenium.testing;

import org.testng.annotations.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

public class SelectAll_Checkboxes {
	public WebDriver  driver;
  @Test
  public void f() {
	 List<WebElement> checkbox = driver.findElements(By.xpath("//td[@class='table5']/input[@type='checkbox']"));
	  System.out.println(checkbox.size());
	  for(int i=0;i<checkbox.size();i++)
	  {
		  if(!checkbox.get(i).isSelected())
		  {
			  checkbox.get(i).click();
		  }
	  }
  }
  @BeforeTest
  public void beforeTest() {
	  driver=new FirefoxDriver();
	  driver.get("http://echoecho.com/htmlforms09.htm");
	  driver.manage().window().maximize();
  }

}

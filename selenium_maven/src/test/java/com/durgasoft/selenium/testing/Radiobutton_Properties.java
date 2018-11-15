package com.durgasoft.selenium.testing;

import org.testng.annotations.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

public class Radiobutton_Properties {
	public WebDriver driver;
  @Test
  public void f() {
	 WebElement headerloc = driver.findElement(By.xpath("(//td[@class='table5'])[2]"));
	 List<WebElement> radio = headerloc.findElements(By.name("group2"));
	 for(int i=0;i<radio.size();i++)
	  {
		  System.out.println(radio.get(i).getAttribute("value")+"--------------"+radio.get(i).getAttribute("checked"));
	  }
  }
  @BeforeTest
  public void beforeTest() {
	  driver=new FirefoxDriver();
	  driver.get("http://echoecho.com/htmlforms10.htm");
	  driver.manage().window().maximize();
  }

}

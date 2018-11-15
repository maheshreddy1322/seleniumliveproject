package com.durgasoft.selenium.testing;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

public class Bokks_in_amazon {
	public WebDriver driver;
  @Test
  public void f() throws Exception {
	  new Select(driver.findElement(By.id("searchDropdownBox"))).selectByVisibleText("Books");
	  driver.findElement(By.id("twotabsearchtextbox")).sendKeys("harry potter");
	  Thread.sleep(6000);
	  String books = driver.findElement(By.xpath("//*[@id='nav-flyout-searchAjax']")).getText();
	  System.out.println(books);
	String[] s = books.split("\n");
	System.out.println(s.length);
	for(int i=0;i<s.length;i++)
	{
		if(s[i].equalsIgnoreCase("harry potter"))
		{
			driver.findElement(By.id("twotabsearchtextbox")).clear();
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys(s[i]);
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);
		}
	}
	String actval=driver.getTitle();
	System.out.println(actval);
	String expval="Amazon.in: harry potter: Books";
	Assert.assertEquals(actval, expval);
  }
  @BeforeTest
  public void beforeTest() {
	  driver=new FirefoxDriver();
	  driver.get("http://amazon.in");
	  driver.manage().window().maximize();
	  
  }

}

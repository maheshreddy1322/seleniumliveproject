package com.durgasoft.selenium.testing;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

public class functionalbasedscreenshot {
	public WebDriver driver;
  @Test
  public void f() throws Exception {
	 List<WebElement> links = driver.findElements(By.tagName("a"));
	 System.out.println("available links are:"+links.size());
	 for(int i=0;i<links.size();i++)
	 {
		 String linkname = links.get(i).getText();
		 System.out.println(linkname);
		 links.get(i).click();
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(src, new File("D:\\screenshots\\"+linkname+".png"));
		 links = driver.findElements(By.tagName("a"));
	 }
  }
  @BeforeTest
  public void beforeTest() {
	  driver=new FirefoxDriver();
	  driver.get("http://newtours.demoaut.com/");
	  driver.manage().window().maximize();
  }

}

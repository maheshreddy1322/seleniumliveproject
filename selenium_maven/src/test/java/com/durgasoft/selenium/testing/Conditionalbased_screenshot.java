package com.durgasoft.selenium.testing;

import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

public class Conditionalbased_screenshot {
	public  WebDriver driver;
  @Test
  public void f() throws Exception {
	 List<WebElement> links = driver.findElements(By.partialLinkText("NEW BATCHES"));
	 System.out.println(links.size());
	 for(int i=0;i<links.size();i++)
	 {
		 System.out.println("link name :"+links.get(i).getText());
		 links.get(i).click();
		 Thread.sleep(6000);
	 }
	 if(!(links.size()==0))
	 {
		 File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(src, new File("D:\\screenshots\\newbatches.jpg"));
		 
	 }
	  
  }
  @BeforeTest
  public void beforeTest() {
	  driver=new FirefoxDriver();
	  driver.get("http://seleniumbymahesh.com");
	  driver.manage().window().maximize();
  }

}

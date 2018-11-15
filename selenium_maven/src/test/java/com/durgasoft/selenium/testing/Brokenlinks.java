package com.durgasoft.selenium.testing;

import org.testng.annotations.Test;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.BeforeTest;

public class Brokenlinks {
	public WebDriver driver;
  @Test
  public void f() throws Exception {
	  List<WebElement> links = driver.findElements(By.tagName("a"));
		 System.out.println("the available links are:"+links.size());
		 for(int i=0;i<links.size();i++)
		 {
			 String linkurl = links.get(i).getAttribute("href");
			 verifyActive(linkurl);
		 }
		  
	  }
	  private void verifyActive(String linkurl) throws Exception {
		URL url=new URL(linkurl);
		HttpURLConnection httpurlconnection=(HttpURLConnection)url.openConnection();
		httpurlconnection.setConnectTimeout(3000);
		httpurlconnection.connect();
		if(httpurlconnection.getResponseCode()==200)
		{
			System.out.println(linkurl+"-----------"+httpurlconnection.getResponseMessage());
		}
		else if(httpurlconnection.getResponseCode()==httpurlconnection.HTTP_NOT_FOUND)
		{
			System.out.println(linkurl+"---------------"+httpurlconnection.getResponseMessage()
			                              +httpurlconnection.HTTP_NOT_FOUND);
		}
		
	}
  
  @BeforeTest
  public void beforeTest() {
	  driver=new FirefoxDriver();
	  driver.get("http://www.newtours.demoaut.com/");
	  driver.manage().window().maximize();
  }

}

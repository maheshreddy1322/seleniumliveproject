package com.durgasoft.selenium.testing;

import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

public class Facebook_login_js {
	public WebDriver driver;
  @Test
  public void f() throws Exception {
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  js.executeScript("document.getElementById('email').value='mahesh'");
	  js.executeScript("document.getElementById('pass').value='abc123'");
	  Thread.sleep(5000);
	  js.executeScript("document.getElementById('u_0_2').click()");
  }
  @BeforeTest
  public void beforeTest() {
	  driver=new FirefoxDriver();
	  driver.get("http://facebook.com");
	  driver.manage().window().maximize();
  }

}

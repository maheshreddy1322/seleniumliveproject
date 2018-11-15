package com.durgasoft.selenium.testing.hybrid;

import org.testng.annotations.Test;

import com.durgasoft.selenium.java.BasePage;
import com.durgasoft.selenium.java.PageUi;

import org.testng.annotations.BeforeTest;

public class Tc001_hms_login_logout extends BasePage {
  @Test
  public void f() {
	  PageUi page=new PageUi(driver);
	  page.HmsLogin();
	  page.HmsLogout();
  }
  @BeforeTest
  public void beforeTest() {
	  BrowserLaunch("firefox", "http://seleniumbymahesh.com");
  }

}

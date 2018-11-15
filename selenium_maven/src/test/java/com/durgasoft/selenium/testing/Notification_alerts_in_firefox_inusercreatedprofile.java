package com.durgasoft.selenium.testing;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.BeforeTest;

public class Notification_alerts_in_firefox_inusercreatedprofile {
	public WebDriver driver;
  @Test
  public void f() {
  }
  @BeforeTest
  public void beforeTest() {
	  ProfilesIni p=new ProfilesIni();
	  FirefoxProfile myprofile=p.getProfile("mahesh");
	  myprofile.setPreference("dom.webnotifications.enabled", false);
	  driver=new FirefoxDriver(myprofile);
	  driver.get("http://redbus.in");
	  driver.manage().window().maximize();
  }

}

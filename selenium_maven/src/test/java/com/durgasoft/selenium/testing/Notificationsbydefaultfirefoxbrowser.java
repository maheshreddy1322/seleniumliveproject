package com.durgasoft.selenium.testing;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

public class Notificationsbydefaultfirefoxbrowser {
	public WebDriver driver;
  @Test
  public void f() {
  }
  @BeforeTest
  public void beforeTest() {
	  FirefoxProfile profile=new FirefoxProfile();
	  profile.setPreference("permissions.default.desktop-notifications", 1);
	  DesiredCapabilities capabilites=DesiredCapabilities.firefox();
	  capabilites.setCapability(FirefoxDriver.PROFILE, profile);
	  driver=new FirefoxDriver(capabilites);
	  driver.get("http://redbus.in");
	  driver.manage().window().maximize();
  }

}

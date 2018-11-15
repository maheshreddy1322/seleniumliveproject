package com.durgasoft.selenium.ecommerce.HomePage;

import org.testng.annotations.Test;

import com.durgasoft.selenium.ecommerce.BasePage.BasePage;
import com.durgasoft.selenium.ecommerce.PageUi.CreateLoginAccount;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
@Listeners(com.durgasoft.selenium.ecommerce.Listeners.Listeners.class)

public class TC001_CustomerRegistration extends BasePage{
	public static final Logger log=Logger.getLogger(TC001_CustomerRegistration.class.getName());
	  

@Test
  public void CustomerRegistration() throws Exception {
	 log.info("************** starting TC001_CustomerRegistration *****************");
	  CreateLoginAccount login=new CreateLoginAccount(driver);
	  login.createAccount();
	  log.info("************** ending TC001_CustomerRegistration *****************");
  }
  @BeforeTest
  public void beforeTest() throws Exception {
	  BrowserLaunch(GetData("browser"),GetData("url"));
	  //BrowserLaunch("chrome", "http://automationpractice.com/");
	 // BrowserLaunch("ie", "http://automationpractice.com/");
  }

  @AfterTest
  public void afterTest() {
	  closeBrowser();
  }
public void closeBrowser() {
	driver.quit();
	extent.endTest(test);
	extent.flush();
	
}

}

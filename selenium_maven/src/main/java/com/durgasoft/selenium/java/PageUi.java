package com.durgasoft.selenium.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageUi {
	@FindBy(linkText="HMS") WebElement linkHms;
	@FindBy(name="username") WebElement TxtUsername;
	@FindBy(name="password") WebElement TxtPassword;
	@FindBy(name="submit") WebElement BtnSubmit;
	@FindBy(linkText="Logout") WebElement linkLogout;
	
	
	public PageUi(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

public void HmsLogin()
{
	linkHms.click();
	TxtUsername.sendKeys("admin");
	TxtPassword.sendKeys("admin");
	BtnSubmit.click();
}
public void HmsLogout()
{
	linkLogout.click();
}
}
package com.durgasoft.selenium.ecommerce.PageUi;

import static org.testng.Assert.assertEquals;

import org.apache.http.util.Asserts;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.GetElementDisplayed;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.durgasoft.selenium.ecommerce.BasePage.BasePage;

public class CreateLoginAccount extends BasePage {
	public static final Logger log=Logger.getLogger(CreateLoginAccount.class.getName());
	@FindBy(linkText="Sign in") WebElement linkSignIn;
	@FindBy(id="email_create") WebElement txtEmailId;
	@FindBy(id="SubmitCreate") WebElement btnCreateAnAccount;
	@FindBy(xpath="//h1[text()='Create an account']") WebElement txtCreateAnAccount;
	@FindBy(id="id_gender1") WebElement radioMr;
	@FindBy(id="customer_firstname") WebElement txtFirstName;
	@FindBy(id="customer_lastname") WebElement txtLastName;
	@FindBy(id="passwd") WebElement txtPassword;
	@FindBy(id="days") WebElement dropDownDays;
	@FindBy(id="months") WebElement dropDownMonths;
	@FindBy(id="years") WebElement dropDownYears;
	@FindBy(id="company") WebElement txtCompany;
	@FindBy(id="address1") WebElement txtAddress1;
	@FindBy(id="address2") WebElement txtAddress2;
	@FindBy(id="city") WebElement txtCity;
	@FindBy(id="id_state") WebElement dropDownState;
	@FindBy(id="postcode") WebElement txtZipCode;
	@FindBy(id="id_country") WebElement dropDownCountry;
	@FindBy(id="phone") WebElement txtHomePhone;
	@FindBy(id="phone_mobile") WebElement txtMobileNo;
	@FindBy(id="alias") WebElement txtAliasAddress;
	@FindBy(id="submitAccount") WebElement btnRegister;
	@FindBy(xpath="//h1[text()='My account']") WebElement txtMyAccount;
	
public CreateLoginAccount(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

public void createAccount() throws Exception
{
	
	linkSignIn.click();
	log.info("click on signin button with object:"+linkSignIn.toString());
	txtEmailId.sendKeys(GetData("firstName")+GetData("lastName")
	                                             +randomnumber()+GetData("domainName"));
	log.info("entering emailid:"+txtEmailId.getAttribute("value")+"using object"+txtEmailId.toString());
	btnCreateAnAccount.click();
	log.info("clicking on create account:"+btnCreateAnAccount.toString());
	Thread.sleep(10000);
	//elementvisible(30,  txtCreateAnAccount);
	assertEquals(txtCreateAnAccount.getText(), "CREATE AN ACCOUNT");
	log.info("verifying customer info page by using object:"+txtCreateAnAccount.toString());
	radioMr.click();
	log.info("clicking on MR radio button by using object:"+radioMr.toString());
	txtFirstName.sendKeys(GetData("firstname"));
	log.info("entering first name by using object:"+txtFirstName.toString());
	txtLastName.sendKeys(GetData("lastname"));
	log.info("entering last name by using object:"+txtLastName.toString());
	txtPassword.sendKeys(GetData("password"));
	log.info("entering password by using object:"+txtPassword.toString());
	selectoption(dropDownDays, 3);
	log.info("selected a country by using object:"+dropDownDays.toString());
	selectoption(dropDownMonths, 3);
	log.info("selected a month by using object:"+dropDownMonths.toString());
	selectoption(dropDownYears, 3);
	log.info("selected a year by using object:"+dropDownYears.toString());
	txtCompany.sendKeys(GetData("company"));
	log.info("entering company name by using object:"+txtCompany.toString());
	txtAddress1.sendKeys(GetData("address1"));
	log.info("entering address1 name by using object:"+txtAddress1.toString());
	txtAddress2.sendKeys(GetData("address2"));
	log.info("entering address2 name by using object:"+txtAddress2.toString());
	txtCity.sendKeys(GetData("city"));
	log.info("entering city name by using object:"+txtCity.toString() );
	selectoption(dropDownState, 3);
	log.info("selected a state by using object:"+dropDownState.toString() );
	txtZipCode.sendKeys("12345");
	log.info("entering zipcode by using object:"+txtZipCode.toString() );
	selectoption(dropDownCountry, 1);
	log.info("selected a country by using object:"+dropDownCountry.toString() );
	txtHomePhone.sendKeys("889966");
	log.info("entering  land mobile number by using object:"+txtHomePhone.toString() );
	txtMobileNo.sendKeys("9848022338");
	log.info("entering  mobile number by using object:"+txtMobileNo.toString() );
	txtAliasAddress.sendKeys(GetData("aliasaddress"));
	log.info("entering alias address by using object:"+txtAliasAddress.toString() );
	btnRegister.click();
	log.info("clicking on register button by using object:"+btnRegister.toString() );
	Thread.sleep(10000);
	assertEquals(txtMyAccount.getText(), "MY ACCOUNT");
	log.info("verifying clicked on signin button by using object:"+txtMyAccount.toString() );
	
}
}
package com.durgasoft.selenium.ecommerce.BasePage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.Calendar;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.google.gson.annotations.Until;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import freemarker.template.utility.DateUtil.CalendarFieldsToDateConverter;

public class BasePage {
	public static WebDriver driver;
	public static final String path="./config.properties";
	public String log4jpath="log4j.properties";
	public  ExtentTest test;
	public static ExtentReports extent;
	public ITestResult result;
	public String GetData(String key) throws Exception
	{
		File f=new File(path);
		FileInputStream fis=new FileInputStream(f);
		Properties p=new Properties();
		p.load(fis);
		return p.getProperty(key);
	}
	public int randomnumber()
	{
		Random r=new Random();
		int random = r.nextInt(9999);
		return random;
	}
	public void selectoption(WebElement element,int option) {
		Select s=new Select(element);
		s.selectByIndex(option);
	}
	public boolean elementvisible (int time,WebElement element ) {
		
		try
		{
			WebDriverWait wait=new WebDriverWait(driver,time);
		
		wait.until(ExpectedConditions.visibilityOf(element));
		return true;
		}catch(Exception e)
		{
			return false;
		}
	}
	public void passedscreens(String method)
	{
		Date dt=new Date();
		DateFormat dtformat=new SimpleDateFormat("DD-MM-YYYY HH-MM-SS");
		    File sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File targetpath = new File("D:\\Users\\seleniumliveproject\\ecommerce\\"
		+ "src\\main\\java\\com\\durgasoft\\selenium\\ecommerce\\PassedScreens\\"+method+"-"+dtformat.format(dt)+".png");
			try {
				FileUtils.copyFile(sourcePath, targetpath);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		
	}
	@AfterMethod
	public void endReport(ITestResult result)
	{
		getResult(result);
	}
	
	public void getResult(ITestResult result2) {
		if(result2.getStatus()==ITestResult.SUCCESS)
		{
			test.log(LogStatus.PASS, result2.getName()+"test is passed");
		}
		else if(result2.getStatus()==ITestResult.SKIP)
		{
			test.log(LogStatus.SKIP, result2.getName()+"test is skipped and the reason is:"+result2.getThrowable());
		}
		else if(result2.getStatus()==ITestResult.FAILURE)
		{
			test.log(LogStatus.FAIL, result2.getName()+"test is failed and the reason is:"+result2.getThrowable());
		}
		}
	static
	{
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat dateformat=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		extent=new ExtentReports(System.getProperty("user.dir")+"\\src\\main\\java\\com\\durgasoft\\selenium\\ecommerce\\htmlReports//test//"+
		dateformat.format(cal.getTime())+".html", false);
	}
	@BeforeMethod
	
		public void startReport(Method result) {
		test=extent.startTest(result.getName());
		test.log(LogStatus.INFO, result.getName()+"test is started");
		}
		
	
	public void BrowserLaunch(String browser,String url)
	{
		if(browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\library\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", "D:\\library\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		PropertyConfigurator.configure(log4jpath);
		
	}

}

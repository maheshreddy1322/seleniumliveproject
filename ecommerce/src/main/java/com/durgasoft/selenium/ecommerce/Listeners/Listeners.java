package com.durgasoft.selenium.ecommerce.Listeners;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.durgasoft.selenium.ecommerce.BasePage.BasePage;

public class Listeners extends BasePage  implements ITestListener {
	

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		/*Reporter.log("Test is sucess "+result.getMethod().getMethodName());
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat simpleDate=new SimpleDateFormat("dd_mm_yyyy hh_mm_ss");
		String methodName = result.getName();
		if(result.isSuccess())
		{
			File sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String reportDirectory = (new File(System.getProperty("user.dir")).getAbsolutePath()
					+"/src/main/java/com/durgasoft/ecommerce/");
			File targetPath = new File((String)reportDirectory+"/passedScreens/"
					+methodName+""+simpleDate.format(cal.getTime()+".png"));
			try {
				FileUtils.copyFile(sourcePath, targetPath);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}*/
		Reporter.log("Test is sucess "+result.getMethod().getMethodName());
		String methodName = result.getName();
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat dtformat=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		    File sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		   File targetpath = new File("D:\\Users\\seleniumliveproject\\ecommerce\\"
+ "src\\main\\java\\com\\durgasoft\\selenium\\ecommerce\\PassedScreens\\"+methodName+"-"+dtformat.format(cal.getTime())+".png");
		    /*String reportDirectory = (new File(System.getProperty("user.dir")).getAbsolutePath()
					+"/src/main/java/com/durgasoft/ecommerce/");
			File targetPath = new File((String)reportDirectory+"/PassedScreens/"
					+methodName+""+dtformat.format(dt)+".png");*/
			try {
				
				FileUtils.copyFile(sourcePath, targetpath);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			Reporter.log("<a href='"+targetpath.getAbsolutePath()+"'>"+"<img src='"+targetpath.getAbsolutePath()
			   +"'height='100' width='100'/></a>");

	}
	

	public void onTestFailure(ITestResult result) {
		Reporter.log("Test is sucess "+result.getMethod().getMethodName());
		String methodName = result.getName();
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat dtformat=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		    File sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		   File targetpath = new File("D:\\Users\\seleniumliveproject\\ecommerce\\"
+ "src\\main\\java\\com\\durgasoft\\selenium\\ecommerce\\FailedScreens\\"+methodName+"-"+dtformat.format(cal.getTime())+".png");
		   try {
				
				FileUtils.copyFile(sourcePath, targetpath);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		   Reporter.log("<a href='"+targetpath.getAbsolutePath()+"'>"+"<img src='"+targetpath.getAbsolutePath()
		   +"'height='100' width='100'/></a>");

	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}

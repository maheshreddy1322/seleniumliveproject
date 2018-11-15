package com.durgasoft.selenium.ecommerce.Listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Retry implements IRetryAnalyzer {
	private int retryCount=0;
	private int maxRetryCount=3;

	public boolean retry(ITestResult result) {
		if(retryCount<maxRetryCount)
		{
			log("Retrying Test"+result.getName()+"with status"+getResultStatusName(result.getStatus())+"for the"
		     +(retryCount+1)+"times");
			retryCount++;
			return true;
		}
		
		return false;
	}
	public void log(String string)
	{
		Reporter.log(string);
	}
	public String getResultStatusName(int status)
	{
		String resultName=null;
		if(status==1)
		{
			resultName="SUCESS";
		}
		if(status==2)
		{
			resultName="FAIL";
		}
		if(status==3)
		{
			resultName="SKIP";
		}
		return resultName;
	}

}

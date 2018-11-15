package com.durgasoft.selenium.ecommerce.Listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class CustomRetryListener implements IRetryAnalyzer {
	private int retryCount=1;
	private int MAX_RETRY_COUNT=5;

	public boolean retry(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE && retryCount<=MAX_RETRY_COUNT)
		{
			try
			{
				Thread.sleep(3000);
				System.out.println(String.format("Method Name : %s Retry Count : %d" , result.getMethod(),retryCount));
				retryCount++;
				return true;
			}
		 catch (Exception e)
		{
			
		}
		}
		return false;
	}
	

}

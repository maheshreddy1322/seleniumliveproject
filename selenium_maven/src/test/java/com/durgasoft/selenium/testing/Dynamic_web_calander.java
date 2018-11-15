package com.durgasoft.selenium.testing;

import org.testng.annotations.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

public class Dynamic_web_calander {
	public WebDriver driver;
  @Test
  public void f() throws Exception {
	  driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
	  driver.findElement(By.xpath("(//button[@class='ui-datepicker-trigger'])[1]")).click();
	  Thread.sleep(5000);
	  //Check in
	  String date="20-October 2018";
	  String[] splitter = date.split("-");
	  String checkindate = splitter[0];
	  String checkinmonth = splitter[1];
	  selectDate(checkinmonth,checkindate);
	  //check Out
	  driver.findElement(By.xpath("//*[@id='Div1']/button")).click();
	  Thread.sleep(20000);
	  String checkdate = "20-December 2018";
	 String[] checksplitter = checkdate.split("-");
	 String checkoutdate = checksplitter[0];
	 String checkoutmonth = checksplitter[1];
	 selectDate(checkoutmonth,checkoutdate);
  }
  public void selectDate(String month_year, String day) throws Exception {
	 List<WebElement> elements = driver.findElements(By.xpath("//*[@id='ui-datepicker-div']/div/div/div"));
	 System.out.println(elements.size());
	 for(int i=0;i<elements.size();i++)
	 {
		 i=0;
		 System.out.println(elements.get(i).getText());
		 if(elements.get(i).getText().equalsIgnoreCase(month_year))
		 {
			 System.out.println("we are in loop");
			List<WebElement> tabledata = driver.findElements
					(By.xpath("//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr/td/a"));
			for(WebElement d:tabledata)
			{
				System.out.println(d.getText());
				if(d.getText().equalsIgnoreCase(day))
				{
					d.click();
					break;
				}
			}
			break;
		 }else {
			 driver.findElement(By.xpath("//span[text()='Next']")).click();
			 Thread.sleep(10000);
			 elements = driver.findElements(By.xpath("//*[@id='ui-datepicker-div']/div/div/div"));
		 }
	 }
	
}
@BeforeTest
  public void beforeTest() {
	  driver=new FirefoxDriver();
	  driver.get("http://spicejet.com");
	  driver.manage().window().maximize();
  }

}

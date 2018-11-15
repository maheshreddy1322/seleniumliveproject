package com.durgasoft.selenium.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.thoughtworks.selenium.webdriven.commands.GetValue;

public class Readdatafrom_Propertyfile {
	public static final String path="./hms.properties";
	public static String getvalue(String key) throws Exception
	{
		File f=new File(path);
		Properties p=new Properties();
		FileInputStream fis=new FileInputStream(f);
		p.load(fis);
return p.getProperty(key);
		
	}

	public static void main(String[] args) throws Exception {
	   System.out.println(getvalue("browser"));
	   WebDriver driver=new FirefoxDriver();
	   driver.get(getvalue("produrl"));
	   driver.manage().window().maximize();
	   driver.findElement(By.name(getvalue("usernameloc"))).sendKeys(getvalue("username"));
	   driver.findElement(By.name(getvalue("pwdloc"))).sendKeys(getvalue("password"));
	   driver.findElement(By.name(getvalue("loginloc"))).click();;

	}

}

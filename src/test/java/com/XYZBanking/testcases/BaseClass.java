package com.XYZBanking.testcases;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.XYZBanking.utilities.ReadConfig;

public class BaseClass{
	
	ReadConfig rc = new ReadConfig();	
	public String BaseURL = rc.getURL();	
	public String userName = rc.getUsername();
	public String password = rc.getPassword();
	
	public static WebDriver driver;
	
	public static Logger logger;
	
	@Parameters({"browser"})
	@BeforeClass
	public void setup(@Optional("chrome") String browser)
	{	 	
		logger = Logger.getLogger("XYZBanking");
		PropertyConfigurator.configure("Log4j.properties");
		logger.setLevel(Level.DEBUG);
		
		
		if(browser.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", rc.getChromePath());
		driver = new ChromeDriver();}
		
		else if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", rc.getFirefoxPath());
			driver = new FirefoxDriver();}
		else if (browser.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", rc.getIEpath());
			driver = new InternetExplorerDriver();}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(BaseURL);
		logger.info(" URL is opened ");


	}
	
	@AfterClass
	public void tearDown() throws InterruptedException
	{
		logger.info("Test Completed ");
		driver.quit();
	}
	
	public void captureScreenShot(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/Screenshots/" +tname+" .png");
		FileUtils.copyFile(source, target);
	}
	
	public  String GenerateEmail()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(5)+ "@"+RandomStringUtils.randomAlphabetic(4)+".com";
		return generatedString;
	}
	
	public  String GeneratePassword()
	{
		String generatedString = RandomStringUtils.randomAlphanumeric(5);
		return generatedString;
	}
}

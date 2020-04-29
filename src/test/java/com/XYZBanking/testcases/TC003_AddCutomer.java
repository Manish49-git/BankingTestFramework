package com.XYZBanking.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.XYZBanking.pageObjects.LoginPage;
import com.XYZBanking.pageObjects.addCustomerPage;

public class TC003_AddCutomer extends BaseClass{
	
	@Test
	public void addNewCutomer() throws InterruptedException, IOException
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(userName);
		lp.setPassword(password);
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		// Add new customer
		
		addCustomerPage custPage = new addCustomerPage(driver);
		custPage.clickAddNewCutomer();
		custPage.AddCutomerName("Manishanandrathode");
		custPage.clickGender("male");
		custPage.AddCutomerDOB("09", "04", "1987");
		Thread.sleep(3000);
		custPage.AddCutomerAddress("5005");
		custPage.AddCutomerCity("Edm");
		custPage.AddCutomerState("ab");
		custPage.AddCutomerPinNo("160014");
		custPage.AddCutomerMobile("9988941032");
		
		String email = GenerateEmail();
		custPage.AddCutomerEmail(email);
		
		String pwd = GeneratePassword();
		custPage.AddCutomerPassword(pwd);
		custPage.clickSubmit();
		Thread.sleep(3000);
		
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if (res == true)
		{
			Assert.assertTrue(true);
			logger.info("Customer has successfully logged in ");
			
		}
		else 
		{
			captureScreenShot(driver,"addNewCutomer");
			Assert.assertTrue(false);
			logger.info("Customer has provided wrong information");
		}
		
	}
	
	

}

package com.XYZBanking.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.XYZBanking.pageObjects.LoginPage;


public class TC001_UserLoginTest extends BaseClass{
	
	@Test
	public void loginTest()
	{
		logger.info(" loginTest() test has been started ");
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.setUserName(userName);
		logger.info(" Entered UserName  ");
		loginPage.setPassword(password);
		logger.info(" Entered Password ");
		loginPage.clickSubmit();
				
		String title = driver.getTitle();
		
		Assert.assertEquals(title, "Guru99 Bank Manager HomePage");
		
	}	

}

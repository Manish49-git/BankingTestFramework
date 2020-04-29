package com.XYZBanking.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.XYZBanking.pageObjects.LoginPage;
import com.XYZBanking.utilities.XLUtils;

public class TC002_DDT_Login extends BaseClass{
	
	@Test(dataProvider = "LoginData")
	public void loginDDT(String userName, String pwd) throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(userName);
		logger.info(" Entered UserName  ");
		lp.setPassword(pwd);
		logger.info(" Entered Password  ");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		if (isAlertPresent()==true)
		{
			driver.switchTo().alert().accept(); // will focus on main page
			Assert.assertTrue(false);
			logger.warn(" Login Failed  ");
		}
		else
		{
			Assert.assertTrue(true);
			logger.info(" Login Failed  ");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept(); 
			driver.switchTo().defaultContent();
			}
		
	}
	
	public boolean isAlertPresent()
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(Exception e)
		{
			return false;
		}		
	}
	
	@DataProvider(name = "LoginData")
	String [][] getData() throws IOException
	{
		String path = System.getProperty("user.dir")+"/src/test/java/com/XYZBanking/testdata/LoginData.xlsx";
		int rowCount = XLUtils.getRowCount(path, "Sheet1");
		int colCount = XLUtils.getCellCount(path, "Sheet1", 1);
		
		 String loginData [][] = new String [rowCount][colCount];
		 
		 for (int i = 1; i<=rowCount;i++)
		 {
			 for (int j=0; j<colCount;j++)
			 {
				 loginData [i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			 }
		 }
		return  loginData;
		
	}

}

package com.XYZBanking.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	
	    By userId = By.name("uid");

	    By userPWD = By.name("password");

	    By titleText =By.className("barone");

	    By loginButton = By.name("btnLogin");
	    
	    By resetButton = By.name("btnReset");
	    
	    By logoutButton = By.xpath("/html/body/div[3]/div/ul/li[15]/a");

	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//WebElement userId = driver.findElement(By.name("uid"));
	//WebElement userPWD = driver.findElement(By.name("password"));
	//WebElement loginButton = driver.findElement(By.name("btnLogin"));
	//WebElement resetButton = driver.findElement(By.name("btnReset"));
	
	public void setUserName (String uname)
	{
		driver.findElement(userId).sendKeys(uname);
	}
	public void setPassword (String password)
	{
		driver.findElement(userPWD).sendKeys(password);
	}
	public void clickSubmit()
	{
		driver.findElement(loginButton).click();
	}
	public void clickReset()
	{
		driver.findElement(resetButton).click();
	}
	
	public void clickLogout()
	{
		driver.findElement(logoutButton).click();
	}
	
}

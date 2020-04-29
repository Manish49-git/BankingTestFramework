package com.XYZBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class addCustomerPage {
	
	WebDriver ldriver;
	
	public addCustomerPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
				
	}
	
	@FindBy(how = How.XPATH, using ="/html/body/div[3]/div/ul/li[2]/a")
	@CacheLookup
	WebElement linkAddCustomer;
	
	@FindBy(how = How.NAME, using ="name")
	@CacheLookup
	WebElement textCustomerName;
	
	@FindBy(how = How.NAME, using ="rad1")
	@CacheLookup
	WebElement radGenMale;
	
	@FindBy(how = How.NAME, using ="rad2")
	@CacheLookup
	WebElement radGenFemale;
	
	@FindBy(how = How.ID_OR_NAME, using ="dob")
	@CacheLookup
	WebElement txtDOB;
	
	@FindBy(how = How.NAME, using ="addr")
	@CacheLookup
	WebElement txtAdd;
	
	@FindBy(how = How.NAME, using ="city")
	@CacheLookup
	WebElement txtCity;
	
	@FindBy(how = How.NAME, using ="state")
	@CacheLookup
	WebElement txtState;
	
	@FindBy(how = How.NAME, using ="pinno")
	@CacheLookup
	WebElement txtPIN;
	
	@FindBy(how = How.NAME, using ="telephoneno")
	@CacheLookup
	WebElement txtMobNum;
	
	@FindBy(how = How.NAME, using ="emailid")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(how = How.NAME, using ="password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(how = How.NAME, using ="sub")
	@CacheLookup
	WebElement btnSubmit;
	
	
	public void clickAddNewCutomer ()
	{
		linkAddCustomer.click();
	}
	
	public void AddCutomerName (String name)
	{
		textCustomerName.sendKeys(name);
	}
	
	public void clickGender (String cgender)
	{
		radGenMale.click();
	}
	
	public void AddCutomerDOB (String mm,String dd,String yyyy)
	{
		txtDOB.sendKeys(mm);
		txtDOB.sendKeys(dd);
		txtDOB.sendKeys(yyyy);
	}

	public void AddCutomerAddress (String addr)
	{
		txtAdd .sendKeys(addr);
	}
	
	public void AddCutomerCity (String city)
	{
		txtCity .sendKeys(city);
	}
	
	public void AddCutomerState (String state)
	{
		txtState .sendKeys(state);
	}
	
	public void AddCutomerPinNo (String pin)
	{
		txtPIN .sendKeys(String.valueOf(pin));
	}
	
	public void AddCutomerMobile (String mno)
	{
		txtMobNum .sendKeys(mno);
	}
	
	public void AddCutomerEmail (String email)
	{
		txtEmail .sendKeys(email);
	}
	
	public void AddCutomerPassword (String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void clickSubmit()
	{
		btnSubmit.click();
	}

}

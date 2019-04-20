package com.nopCommerce.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver= rdriver;
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(id="Email")
	@CacheLookup
	WebElement email;
	
	@FindBy(id="Password")
	@CacheLookup
	WebElement password;
	
	@FindBy(xpath = "/html/body/div[6]/div/div/div/div/div[2]/div[1]/div[2]/form/div[3]/input")
	@CacheLookup
	WebElement loginBtn;
	
	@FindBy(xpath="/html/body/div[3]/div[1]/div/div/ul/li[3]/a")//this shoulnot be in this class
	@CacheLookup
	WebElement logoutBtn;
	
	public void setEmail(String uname)
	{
		email.sendKeys(uname);
	}
	
	public void setPassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	public void clickloginBtn()
	{
		loginBtn.click();	
	}
	public void clicklogoutBtn()
	{
		logoutBtn.click();	
	}
	
}



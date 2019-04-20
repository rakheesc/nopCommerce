package com.nopCommerce.TestCases;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.nopCommerce.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{
			
	
	@Test
	public void loginTest() throws InterruptedException, IOException
	{
		logger.info("******************* Started TC_LoginTest_001******************* ");
		logger.debug("******************* Started TC_LoginTest_001******************* ");
		driver.get(baseURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		LoginPage lp = new LoginPage(driver);
		
		logger.info("******************* Providing login info********************* ");
		lp.setEmail(username);
		lp.setPassword(password);
		lp.clickloginBtn();
		Thread.sleep(2000);
		if (driver.getTitle().equals("Dashboard / nopCommerce administration")) //adding 1 to fail the testscreen sh
		{
			
			lp.clicklogoutBtn();
			logger.info("******************* Login Successful******************* ");
			Assert.assertTrue(true);
		} else
		{
			logger.error("******************* Login Failed******************* ");
			captureScreen(driver,"loginTest"); //capturing screent on failure
			Assert.assertTrue(false);
		}
		
		logger.info("******************* Completed TC_LoginTest_001******************* ");
		logger.debug("******************* completed TC_LoginTest_001******************* "); 
	}

}

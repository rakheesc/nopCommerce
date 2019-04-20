package com.nopCommerce.TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nopCommerce.pageObjects.LoginPage;
import com.nopCommerce.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass
{

	@Test(dataProvider = "logindata")
	public void loginTest(String user,String pwd) throws InterruptedException, IOException
	{
		logger.info("******************* Started TC_LoginDDT_002******************* ");
		logger.debug("******************* Started TC_LoginDDT_002******************* ");
		driver.get(baseURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		LoginPage lp = new LoginPage(driver);
		
		logger.info("******************* Providing login info********************* ");
		lp.setEmail(user);
		lp.setPassword(pwd);
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
		
		logger.info("******************* Completed TC_LoginLoginDDT_002******************* ");
		logger.debug("******************* completed TC_LoginLoginDDT_002******************* "); 
	}

	@DataProvider(name = "logindata")
	public String[][] getData() throws IOException
	{
	    String path = System.getProperty("user.dir")+ "\\testData\\LoginData.xlsx";
		//String path = "./testData/LoginData.xlxs";
		int rowCount = XLUtils.getRowCount(path, "Sheet1");
		int colCount = XLUtils.getCellCount(path, "Sheet1", 1);
		String loginData[] [] = new String [rowCount][colCount];
		for(int r=1;r<=rowCount;r++)
		{
			for(int c=0; c<colCount;c++)
			{
				
				loginData[r-1][c]= XLUtils.getCellData(path, "Sheet1", r, c); 
			}
		
		}
				
		return loginData;
	}
	
	
	
	
	
	
	
}

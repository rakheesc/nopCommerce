package com.nopCommerce.TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopCommerce.pageObjects.AddCustomerPage;
import com.nopCommerce.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass

{
     @Test
     public void addNewCustomer() throws InterruptedException, IOException
     {
    	driver.get(baseURL);
    	driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 		LoginPage lp = new LoginPage(driver);
 		lp.setEmail(username);   
 		lp.setPassword(password);
 		lp.clickloginBtn();   

 		logger.info("***************   TC_AddCustomerTest_003 statred  *********** ");
        AddCustomerPage addcust = new AddCustomerPage(driver);
        addcust.clickOnCustomersMenu();
		addcust.clickOnCustomersMenuItem();
		addcust.clickOnAddnew();

		logger.info("***************  Providing customer details  *********** ");
		
		String email=randomstring()+"@gmail.com";
		
		addcust.setEmail(email);
		addcust.setPassword("test123");
		addcust.setCustomerRoles("Guest");
		addcust.setManagerOfVendor("Vendor 2");
		addcust.setGender("Female");
		addcust.setFirstName("mercury");
		addcust.setLastName("mercury");
		addcust.setDob("7/05/1985"); // Format: D/MM/YYY
		addcust.setCompanyName("busyQA");
		addcust.setAdminContent("This is for testing.........");
		addcust.clickOnSave();
		
		// validation

				String msg = driver.findElement(By.tagName("body")).getText();

				if (msg.contains("The new customer has been added successfully"))
				{
					logger.info("***************  Customer added succesfully *********** ");
					Assert.assertTrue(true);

				} else {
					logger.error("*************** Customer Not added succesfully *********** ");
					captureScreen(driver,"addNewCustomer");
					Assert.assertTrue(false);
				}

				logger.info("***************   TC_AddCustomerTest_003 completed  *********** ");
						
    	 
    	 
    	 
    	 
     }
	
	
	
	
}

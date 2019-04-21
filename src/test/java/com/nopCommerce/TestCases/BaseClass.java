package com.nopCommerce.TestCases;

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
import org.testng.annotations.Parameters;

import com.nopCommerce.utilities.ReadConfig;

/*
*
*
*
*/
public class BaseClass {
	
	ReadConfig readConfig = new ReadConfig();
	
	public String baseURL= readConfig.getApplicationURL();
	public String username=readConfig.getUserEmail();
	public String password=readConfig.getPassword();
	public  WebDriver driver;
	public Logger logger;
	
	
	@BeforeClass
	@Parameters("browser")
	void setUp(String br)
	{			
		logger= Logger.getLogger("nopCommerce");
		PropertyConfigurator.configure("log4j.properties");
		logger.setLevel(Level.DEBUG);
		if(br.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",readConfig.getChromePath() );
			// System.setProperty("webdriver.chrome.driver","C:\\Downloads\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(br.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver",readConfig.getIEPath() );
			driver=new InternetExplorerDriver();
		}
		else if(br.equalsIgnoreCase("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver",readConfig.getFirefoxPath() );
			driver=new FirefoxDriver();
		}
		
		
		
	}
	@AfterClass
	void tearDown()
	{
		driver.close();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "\\Screenshots\\" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}

	public String randomstring() {
		String generatedString1 = RandomStringUtils.randomAlphabetic(5);
		return generatedString1;
	}

	public String randomNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return generatedString2;
	}
	
	
}

package com.nopCommerce.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig 
{

    Properties property;
	
	public ReadConfig()
	{
		File src = new File("./Configuration/config.properties");
		

		try {
			FileInputStream fis = new FileInputStream(src);
			property = new Properties();
			property.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}
	
	public String getApplicationURL()
	{
		String url = property.getProperty("baseURL");
		return url;
	}
	
	public String getUserEmail()
	{
		String userEmail = property.getProperty("useremail").trim();
		return userEmail;
	}
	
	public String getPassword()
	{
		String password = property.getProperty("password").trim();
		return password;
	}
	
	public String getChromePath()
	{
		String chromePath = property.getProperty("chromepath");
		return chromePath;
	}
	
	public String getFirefoxPath()
	{
		String firefoxPath = property.getProperty("firefoxpath");
		return firefoxPath;
	}
	
	public String getIEPath()
	{
		String iePath = property.getProperty("iepath");
		return iePath;
	}
	
	
	
}

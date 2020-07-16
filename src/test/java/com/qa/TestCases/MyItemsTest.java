package com.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.MyItemsPage;



public class MyItemsTest  extends TestBase{
	
	LoginPage lp;
	HomePage hp;
	//DevicesPage dp;
	MyItemsPage MI;
	
	public MyItemsTest()
	{ //calling super class constructor (Properties file from TEstBase)
		super();
	}
	@BeforeMethod
	public void setUp()
	{
		
		initialization();
		
		 lp= new LoginPage();
		 
		hp= lp.login(prop.getProperty("username"), prop.getProperty("password"));
		MI= new MyItemsPage();
		hp.clickingOnMyItems();
		
		
		
	}
	
	@Test
	public void verifyURL()
	{
		String url=MI.ValidateURL();
	Assert.assertEquals(url, "https://itassetmanagement.in/travel_triangle/my-items", "Url is not the same as expected");	
	}

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}

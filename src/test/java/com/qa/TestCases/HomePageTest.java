package com.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	LoginPage lp;
	HomePage hp;
	
	public HomePageTest()
	{ //calling super class constructor (Properties file from TEstBase)
		super();
	}
	
	//test cases should be separated and can not depend on each other
	//before each testCase launch browser and login
	//after each testcase close the browser
	@BeforeMethod
	public void setUp()
	{
		
		initialization();
		
		
		 lp= new LoginPage();
		 
		hp= lp.login(prop.getProperty("username"), prop.getProperty("password"));
	}
		 
		 @Test(priority=1)
		 public void HomePageTitleTest()
		 {
			String title= hp.validateHomePageTitle();
			Assert.assertEquals(title, "Login - ITM","Title is not as expected");
		 }
		 @Test(priority=2)
		 public void validateLogoTest()
		 {
			boolean flag=hp.ValidateLogo();
			Assert.assertTrue(flag);
		
		
	      }
		 @Test(priority=3)
		 public void ClickingOnDevices()
		 {
			 hp.clickingOnDevices();
		 }
		 
		 @Test(priority=4)
		 public void HPageTest()
		 {
			 hp.ValidateDashboardOnHomePage();
			 
		 }
		 
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}


}

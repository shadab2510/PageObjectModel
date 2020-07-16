package com.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage lp;
	HomePage hp;
	
	public LoginPageTest()
	{ //calling super class constructor (Properties file from TEstBase)
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		
		initialization();
		
		 lp= new LoginPage();
	}
		 
		 @Test(priority=1)
		 public void loginPageTitleTest()
		 {
			String title= lp.validateLoginPageTitle();
			Assert.assertEquals(title, "Login - ITM","Title is not as expected");
		 }
		 @Test(priority=2)
		 public void validateLogoTest()
		 {
			boolean flag=lp.ValidateLogo();
			Assert.assertTrue(flag);
		
		
	      }
		 
		 @Test(priority=3)
		 public void loginTest()
		 {
			 lp.login(prop.getProperty("username"), prop.getProperty("password"));
			 
		 }
		 
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}

package com.qa.TestCases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.DevicesPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.utils.TestUtil;
import com.qa.utils.Xls_Reader;

public class DevicesPageTest extends TestBase {

	LoginPage lp;
	HomePage hp;
	DevicesPage dp;
	
	public DevicesPageTest()
	{ //calling super class constructor (Properties file from TEstBase)
		super();
	}
	@BeforeMethod
	public void setUp()
	{
		
		initialization();
		
		 lp= new LoginPage();
		 
		hp= lp.login(prop.getProperty("username"), prop.getProperty("password"));
		dp= new DevicesPage();
		dp.ClickingOnDeviceModule();
		
		
	}
	
	
	@Test(priority=4)
	public void TitleOnDevicePageTest()
	{
		boolean title=dp.VerifyDeviceTitleOnDevicePage();
		Assert.assertTrue(title);
	}
	
	@Test(priority=2)
	public void VerifyDevicePageURL()
	{
		String url=dp.VerifyCurrentUrl();
		Assert.assertEquals(url, "https://itassetmanagement.in/travel_triangle/devices","Actual url is not the same as expected");
	}
	/*
	 * @Test(priority=3) public void VerifyAddDevice() { dp.clickOnAddDevice();
	 * 
	 * Assert.assertTrue(dp.ValidateAddDevice());
	 * 
	 * }
	 */
	
	@DataProvider
	public Object[][] getITMDeviceData()
	{
		Object data[][]=TestUtil.getTestData(TestUtil.sheetname);
	return data;
	}
	
	@Test(priority=1,dataProvider="getITMDeviceData")
	public void AddingNewDevice(String DeviceTag,String DeviceModel,String Company,String Location, String DeviceStatus, String SerialCode)
	
		

	{
		dp.clickOnAddDevice();
		//dp.AddNewDevice("TT6ty", "MS116", "Holiday Triangle Travel Pvt Ltd", "Gurgaon", "Ready to Deploy", "234ff45");
		dp.AddNewDevice(DeviceTag,DeviceModel, Company, Location, DeviceStatus, SerialCode);
		
		
	}
	
	
	
	
	@AfterMethod
	
	public void tearDown()
	{
		driver.quit();
	}

	
}

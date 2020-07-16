package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class HomePage  extends TestBase{
	
	//Page Factory -OR;
		@FindBy(xpath="//h3[contains(@class,'darkpanel-title')]")
		public WebElement dashboard;
		
		@FindBy(xpath="//strong[text()='Devices']")
		public WebElement Devices;
		
		@FindBy(xpath="//strong[text()='My Items']")
		public WebElement MyItems;
		
		
		
		@FindBy(xpath="//img[@alt='ITM Logo']")
		public WebElement Logo;
		
		
		
		
		public HomePage()
		{
			PageFactory.initElements(driver, this);
			
			
		}
		
		//Actions
		
		public String validateHomePageTitle()
		{
			return driver.getTitle();
		}
		
		public boolean ValidateLogo()
		{
		
			return Logo.isDisplayed();
		}
		
		public DevicesPage clickingOnDevices()
		{
			 Devices.click();
			 return  new DevicesPage();
		}
		
		
		
		public MyItemsPage clickingOnMyItems()
		{
			MyItems.click();
			return new MyItemsPage();
		}
		
		public boolean ValidateDashboardOnHomePage()
		{
			return dashboard.isDisplayed();
		}
		
		
}

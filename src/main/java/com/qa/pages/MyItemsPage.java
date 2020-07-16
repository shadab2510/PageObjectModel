package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class MyItemsPage extends TestBase {
	
	
	  //@FindBy(xpath="//strong[text()='My Items']") public WebElement MyItems;
	 
	
	
	
	public MyItemsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	public String ValidateURL()
	{
		return driver.getCurrentUrl();
	}

	
	
}

package com.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomePage {
	
	public HomePage(AndroidDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@Test
	public void Test5()
	{
		Accessibility.click();
	}
	
	
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Accessibility']")
	public WebElement Accessibility;
	
	
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Animation']")
	public WebElement Animation;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='App']")
	public WebElement App;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Content']")
	public WebElement Content;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Graphics']")
	public WebElement Graphics;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Media']")
	public WebElement Media;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='NFC']")
	public WebElement NFC;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='OS']")
	public WebElement OS;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Preference']")
	public WebElement Preference;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Text']")
	public WebElement Text;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Views']")
	public WebElement Views;
	
	
	
	
	

}

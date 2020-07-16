package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LoginPage  extends TestBase{
	
	//Page Factory -OR;
	@FindBy(name="username")
	public WebElement username;
	
	@FindBy(id="password")
	public WebElement password;
	
	@FindBy(id="btnSubmit")
	public WebElement SubmitBtn;
	
	@FindBy(xpath="//img[contains(@src,'uploads')]")
	public WebElement logo;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
		
		
	}
	
	//Actions
	
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean ValidateLogo()
	{
	
		return logo.isDisplayed();
	}
	
	public HomePage login(String un,String pw)
	{
		username.sendKeys(un);
		password.sendKeys(pw);
		
		SubmitBtn.click();
		return new HomePage();
		
	}
	
	

}

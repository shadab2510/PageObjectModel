package com.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;
import com.qa.utils.TestUtil;

public class DevicesPage extends TestBase {
	
	@FindBy(xpath="//strong[text()='Devices']")
	@CacheLookup
	public WebElement Devices;
	
	@FindBy(xpath="//h3[contains(@class,'title')]")
	public WebElement DevicesTitle;
	
	@FindBy(xpath="//button[contains(@class,'btn-add-device')]")
	public WebElement AddDevice;
	
	@FindBy(xpath="//h4[text()='Add New Device']")
	public WebElement VerifyAddDevice;
	
	@FindBy(id="asset_tag")
	public WebElement DeviceTag;
	
	@FindBy(xpath="//span[text()='Select the Model']")
	public WebElement DeviceModel;
	
	@FindBy(css="[type='search']")
	public WebElement DeviceModelTextBox;
	
	@FindBy(xpath="//span[text()='Select Companyyyyyyyyyyyyyyyyyyyyyyy']")
	public WebElement Company;
	
	@FindBy(css="[type='search']")
	public WebElement CompanyTextbox;
	

	@FindBy(xpath="//span[text()='Select the Location']")
	public WebElement Location;
	
	@FindBy(css="[type='search']")
	public WebElement LocationTextBox;
	
	@FindBy(xpath="//span[text()='Select Status']")
	public WebElement DeviceStatus;
	
	@FindBy(css="[type='search']")
	public WebElement StatusTextBox;
	
	@FindBy(xpath="//input[@id='serial']")
	public WebElement SerialNumber;
	
	@FindBy(xpath="//button[@id='btnSubmit' and text()='Add New Device']")
	public WebElement AddNewDeviceBtn;
	
	@FindBy(xpath="button[class='vex-dialog-button-primary vex-dialog-button vex-first']")
	public WebElement OkBtnPostAddingDevice;
	
	
	public DevicesPage()
	{
		PageFactory.initElements(driver, this);
		
		
	}
	
	public void ClickingOnDeviceModule()
	{
		Devices.click();
	}
	public boolean VerifyDeviceModule()
	{
	return Devices.isDisplayed();
		
	}
	public String VerifyCurrentUrl()
	{
		return driver.getCurrentUrl();
	}
	
	
	public boolean VerifyDeviceTitleOnDevicePage()
	{
		return DevicesTitle.isDisplayed();
		
	}
	
	public void clickOnAddDevice()
	{
		AddDevice.click();	
	}
	
	public boolean ValidateAddDevice()
	{
		return VerifyAddDevice.isDisplayed();
	}

	public void AddNewDevice(String tag,String Model,String com,String Loc,String Status,String SN)
	{
		DeviceTag.sendKeys(tag);
		DeviceModel.click();
		TestUtil.StaticWait();
		DeviceModelTextBox.sendKeys(Model);
		TestUtil.StaticWait();
		DeviceModelTextBox.sendKeys(Keys.ENTER);
	
		Company.click();
		TestUtil.StaticWait();
		CompanyTextbox.sendKeys(com);
		TestUtil.StaticWait();
		CompanyTextbox.sendKeys(Keys.ENTER);
		
		Location.click();
		TestUtil.StaticWait();
		LocationTextBox.sendKeys(Loc);
		TestUtil.StaticWait();
		LocationTextBox.sendKeys(Keys.ENTER);
		
		DeviceStatus.click();
		TestUtil.StaticWait();
		StatusTextBox.sendKeys(Status);
		TestUtil.StaticWait();
		StatusTextBox.sendKeys(Keys.ENTER);
		
		SerialNumber.sendKeys(SN);
		//AddNewDeviceBtn.click();
		//OkBtnPostAddingDevice.click();
		
	}
}

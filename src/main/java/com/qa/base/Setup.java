package com.qa.base;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.pageObject.HomePage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Setup {
	
	//public AndroidDriver driver;
	@Test
	public AndroidDriver<AndroidElement> Setup1() throws MalformedURLException
	{
		File dir = new File("src/main/java");
		File app= new File(dir,"ApiDemos-debug.apk");
		
		DesiredCapabilities ds= new DesiredCapabilities();
		
		ds.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		ds.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		//ds.setCapability(MobileCapabilityType., value);
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL ("http://127.0.0.1:4723/wd/hub"),ds);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;
		
		 
	}

}

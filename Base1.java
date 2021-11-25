package com_cg;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Base1 {
	public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException
	{
		
		
		File appDir = new File("src");
		File app = new File(appDir, "General-Store.apk");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android test");
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 10);
		AndroidDriver<AndroidElement> driver;
		driver = new AndroidDriver<>(new URL("http://127.0.1.1:4723/wd/hub"), cap);
		return driver;
	}

}

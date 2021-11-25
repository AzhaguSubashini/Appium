package com_cg;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class baseBrowser {

	public static AndroidDriver<AndroidElement> Capabilities() throws MalformedURLException {

		AndroidDriver<AndroidElement> driver;
		
		DesiredCapabilities cap= new DesiredCapabilities();
cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android test");
cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
cap.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
cap.setCapability("chromedriverExecutable", "C:\\Users\\asubashi\\Downloads\\chromedriver_win32 (2)");
driver = new AndroidDriver<>(new URL("http://127.0.1.1:4723/wd/hub"),cap);
return driver;
	}
}

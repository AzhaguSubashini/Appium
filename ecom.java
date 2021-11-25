package com_cg;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ecom extends Base1{

	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementById("android:id/text1").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Antarctica\"));");
		driver.findElementByXPath("//*[@text='Antarctica']").click();
		//driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Manju");
		driver.hideKeyboard();
		driver.findElementById("com.androidsample.generalstore:id/radioFemale").click();
		driver.findElementByClassName("android.widget.Button").click();
		String toastMessage=driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");



		System.out.println(toastMessage);

		//Assert.assertEquals("Please enter your name", toastMessage);//Actual validation
	}

}

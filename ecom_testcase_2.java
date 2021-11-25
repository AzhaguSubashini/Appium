package com_cg;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;


import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ecom_testcase_2 extends Base1{

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementById("android:id/text1").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Antarctica\"));");
		driver.findElementByXPath("//*[@text='Antarctica']").click();
		driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Manju");
		driver.hideKeyboard();
		driver.findElementById("com.androidsample.generalstore:id/radioFemale").click();
		driver.findElementByClassName("android.widget.Button").click();
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0))"));
		int count=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		for(int i=0;i<count;i++)
		{
			String test = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			if (test.equalsIgnoreCase("Jordan 6 Rings")) {
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
				break;
			}
			
			}
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"PG 3\").instance(0))"));
		int count1=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		for(int i=0;i<count1;i++)
		{
			String test1 = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			if (test1.equalsIgnoreCase("PG 3")) {
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
				break;
			}
			
			}
driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
Thread.sleep(1000);
String name = driver.findElementsById("com.androidsample.generalstore:id/productName").get(0).getText();
String name1 = driver.findElementsById("com.androidsample.generalstore:id/productName").get(1).getText();
System.out.println(name);

    if(name.equalsIgnoreCase("Jordan 6 Rings")){
    	System.out.println("Test has passed");
    }
    System.out.println(name1);
    if(name1.equalsIgnoreCase("PG 3")){
    	System.out.println("Test has passed");
    }
	}
}

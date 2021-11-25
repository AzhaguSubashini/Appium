package com_cg;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static io.appium.java_client.touch.offset.ElementOption.element;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static java.time.Duration.ofSeconds;

public class ecom_testcase_5 extends Base1{

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
    int count2 = driver.findElementsById("com.androidsample.generalstore:id/productPrice").size();
    double sum = 0;
    for(int i=0;i<count2;i++) {
    String a1= driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(i).getText();
    double amount = getamount(a1);
    sum = sum+amount;
    }

   
   
   System.out.println(sum);
   
    String totalamt= driver.findElementById("com.androidsample.generalstore:id/totalAmountLbl").getText();
   double tamt = getamount(totalamt);
    System.out.println(tamt);
	
	  if(tamt==sum) { System.out.println("Sum of two product is same"); }
	//Mobile gestures
		WebElement checkbox = driver.findElementByClassName("android.widget.CheckBox");
		TouchAction t = new TouchAction(driver);
		t.tap(tapOptions().withElement(element(checkbox))).perform();
		WebElement tc= driver.findElementByXPath("//*[@text='Please read our terms of conditions']");
		t.longPress(longPressOptions().withElement(element(tc)).withDuration(ofSeconds(2))).release().perform();
		driver.findElementById("android:id/button1").click();
		driver.findElementByXPath("//*[@text='Visit to the website to complete purchase']").click();
	
	}
	
	
	public static double getamount(String Value) {
		Value = Value.substring(1);
		double amt = Double.parseDouble(Value);
		return amt;
}
	
}

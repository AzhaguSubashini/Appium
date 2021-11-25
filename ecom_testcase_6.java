package com_cg;

import java.net.MalformedURLException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import static io.appium.java_client.touch.offset.ElementOption.element;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static java.time.Duration.ofSeconds;

public class ecom_testcase_6 extends Base1{

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
		
driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
Thread.sleep(1000);
String name = driver.findElementsById("com.androidsample.generalstore:id/productName").get(0).getText();
System.out.println(name);

    if(name.equalsIgnoreCase("Jordan 6 Rings")){
    	System.out.println("Test has passed");
    }
   
	//Mobile gestures
		WebElement checkbox = driver.findElementByClassName("android.widget.CheckBox");
		TouchAction t = new TouchAction(driver);
		t.tap(tapOptions().withElement(element(checkbox))).perform();
		
driver.findElementByXPath("//*[@text='Visit to the website to complete purchase']").click();
	
Thread.sleep(7000);
	//context collecting
	
Set<String> context = driver.getContextHandles();
for(String contextname:context) {
	System.out.println(contextname);
}
driver.context("WEBVIEW_com.androidsample.generalstore");
Thread.sleep(3000);
driver.findElement(By.xpath("//*[@name='q']")).sendKeys("Hello");
driver.findElement(By.xpath("//*[@name='q']")).sendKeys(Keys.ENTER);
driver.pressKey(new KeyEvent(AndroidKey.BACK));
driver.context("NATIVE_APP");
	
}}

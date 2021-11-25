package com_cg;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;


import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class DragandDrop extends Base {
	public static void main(String[] args) throws MalformedURLException {
	AndroidDriver<AndroidElement> driver = capabilities();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
	driver.findElementByAndroidUIAutomator("text(\"Drag and Drop\")").click();
	TouchAction t = new TouchAction(driver);
	WebElement source = driver.findElementsByClassName("android.view.View").get(0);
	WebElement desc = driver.findElementsByClassName("android.view.View").get(1);
	t.longPress(longPressOptions().withElement(element(source))).moveTo(element(desc)).release().perform();
}
}
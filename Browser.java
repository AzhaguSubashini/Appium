package com_cg;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Browser extends baseBrowser{

	public static void main(String[] args) throws MalformedURLException  {
		AndroidDriver<AndroidElement> driver = Capabilities();
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");

		driver.findElement(By.cssSelector(".navbar-toggler")).click();

		driver.findElement(By.cssSelector("a[href*='products']")).click();

		JavascriptExecutor js= (JavascriptExecutor)driver;

		js.executeScript("window.scrollBy(0,1000)", "");

		driver.findElement(By.xpath("(//li[@class='list-group-item'])[3]/div/div/a")).getText();

		//Assert.assertEquals(text, "Devops");
		
	}

}

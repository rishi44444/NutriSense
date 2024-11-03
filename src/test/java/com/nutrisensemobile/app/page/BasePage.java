package com.nutrisensemobile.app.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;

public class BasePage {
	public AppiumDriver driver;
	
	public BasePage(AppiumDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getElementByText(String text)
	{
		return driver.findElement(By.xpath("//android.widget.TextView[@text='"+text+"']"));
	}
	
	public WebElement getElementByContentDesc(String text)
	{
		return driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='"+text+"']"));
	}
}

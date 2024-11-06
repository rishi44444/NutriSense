package com.nutrisensemobile.app.page;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

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
	
	public void scrollDown() {
		// Get the screen size
		Dimension size = driver.manage().window().getSize();

		int startX = size.width / 2;
		int startY = (int) (size.height * 0.8); // Start near the bottom of the screen
		int endY = (int) (size.height * 0.2); // End near the top of the screen

		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence swipe = new Sequence(finger, 1);

		swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));
		swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		swipe.addAction(
				finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), startX, endY));
		swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		driver.perform(Arrays.asList(swipe));
	}
}

package com.nutrisensemobile.app.page;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nutrisensemobile.app.utility.Appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage extends BasePage {
	
	@FindBy(xpath = "//android.widget.TextView[@text='Skip']")
	private WebElement skipButton;
	
	@FindBy(xpath = "//android.widget.EditText[@content-desc='Email']")
	private WebElement emailId;
	
	@FindBy(xpath = "//android.widget.EditText[@resource-id='SigninScreen/Password']")
	private WebElement passwordElement;
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id='Snackbar/TitleText']")
	private WebElement errorMessage;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Sign In']") //
	private WebElement signInButtonStatus;
	
	@FindBy(xpath = "//android.view.ViewGroup[@resource-id='SigninScreen/Logo']/android.view.ViewGroup/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView/com.horcrux.svg.PathView") 
	private WebElement clickNutrisenseLogo;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Admin Settings']/following-sibling::android.view.ViewGroup/android.widget.TextView") 
	private WebElement changeAdminSettings;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Staging']") 
	private WebElement selectSettings;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Glucose Dial Chart\"]/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView/com.horcrux.svg.PathView") 
	private WebElement verifyGlucoseChart;
	
	public LoginPage() {
		super(Appium.driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
	}

	public void openLoginPage() {

	}

	public void enterEmail(String email) {
		// Login button is disabled
		emailId.sendKeys(email);
	}

	public void enterPassword(String password) {
		passwordElement.sendKeys(password);
	}

	public void clickOnSkipButton() {
		skipButton.click();
	}
	public void clickButtonByDesc(String buttonName) {
		getElementByContentDesc(buttonName).click();
	}

	public void verifyErrorMessage(String message) {
		String actualMessage = errorMessage.getText();
		Assert.assertEquals(message, actualMessage);
	}


	public void verifyButtonStatusByDesc(String buttonName , String expectedButtonStatus) {
		boolean buttonStatus = getElementByContentDesc(buttonName).isEnabled();
		String actualButtonStatus = "";
		if(buttonStatus)
			actualButtonStatus = "enabled";
		else
			actualButtonStatus = "disabled";
		
		Assert.assertEquals(expectedButtonStatus, actualButtonStatus);
	}

	public void verifyButtonStatusByText(String buttonName , String expectedButtonStatus) {
		boolean buttonStatus = getElementByText(buttonName).getAttribute("clickable").equals("true");
		String actualButtonStatus = "";
		if(buttonStatus)
			actualButtonStatus = "enabled";
		else
			actualButtonStatus = "disabled";
		
		Assert.assertEquals(expectedButtonStatus, actualButtonStatus);
	}
	public void clickNutrisenseLogo() {
		clickNutrisenseLogo.click();
		
	}

	public void changeAdminSettings(String expEnv) {
		String actualEnv = changeAdminSettings.getText();
		if(!expEnv.equalsIgnoreCase(actualEnv)) {
			changeAdminSettings.click();
			selectSettings.click();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.invisibilityOf(errorMessage));
		}
	}

	public void verifyGlucoseChart() {
		verifyGlucoseChart.isDisplayed();

	}

	public void clickButtonByText(String buttonName) {
		getElementByText(buttonName).click();		
	}

}

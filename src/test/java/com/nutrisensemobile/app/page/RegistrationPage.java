package com.nutrisensemobile.app.page;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nutrisensemobile.app.utility.Appium;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class RegistrationPage extends BasePage{

//	public AppiumDriver driver;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Log In']")
	private WebElement loginButton ;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Register']")
	private WebElement register;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Sign Up with Email button']")
	private WebElement signUpWithEmailButton;
	
	@FindBy(xpath = "//android.widget.EditText[@resource-id='SignupScreen/FirstName']")
	private WebElement enterFirstName;
	
	@FindBy(xpath = "//android.widget.EditText[@resource-id='SignupScreen/LastName']")
	private WebElement enterLastName;
	
	@FindBy(xpath = "//android.widget.EditText[@resource-id='SignupScreen/Email']")
	private WebElement enterEmail;
	
	@FindBy(xpath = "//android.widget.EditText[@resource-id='SignupScreen/Password']")
	private WebElement enterPassword;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='I agree to the Terms & Conditions, Telehealth Consent, Privacy Policy']/android.view.ViewGroup")
	private WebElement termsAndConditionCheckbox;
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id='Snackbar/TitleText']")
	private WebElement messageBar;
	
	@FindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup")
	private WebElement selectCgmPage;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Member with this email already exists!']")
	private WebElement ErrorMessage;
	
	
	
	public RegistrationPage() {
		super(Appium.driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
	}

	public void loginButton() {		
		loginButton.click();
	}

	public void register() {
		register.click();
		
	}
	
	public void signUpWithEmailButton() {
		signUpWithEmailButton.click();
	}

	public void enterFirstName(String firstName) {
		enterFirstName.sendKeys(firstName);
	}

	public void enterLastName(String lastName) {
		enterLastName.sendKeys(lastName);
	} 
	

	public void enterEmail(String email) {
		enterEmail.sendKeys(email);
	}

	public void enterPassword(String password) {
		enterPassword.sendKeys(password);
	}
	
	public void selectTermAndConditionCheckbox() {		
		termsAndConditionCheckbox.click();
	}

	public void verifyButtonIsDisabled(String string, String string2) {
		
		
	}

	public void verifyErrorMessage(String string) {
		ErrorMessage.isDisplayed();		
	}

	public void verifyPasswordStrength(String text) {
		getElementByText(text).isDisplayed();
	}

	public void verifyScreen() {
		boolean displayed = selectCgmPage.isDisplayed();
		Assert.assertTrue(displayed);
	}

}

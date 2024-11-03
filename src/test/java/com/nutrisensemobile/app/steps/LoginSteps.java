package com.nutrisensemobile.app.steps;

import com.nutrisensemobile.app.page.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LoginSteps {

	LoginPage loginPage = new LoginPage();
	
	@Given("user click on skip button from landing screen")
	public void click_on_skip_button() {
		loginPage.clickOnSkipButton();
	}
	@Given("the user enters a valid email {string} and password {string}")
	public void the_user_enters_a_valid_email_and_password(String email, String password) {
		loginPage.enterEmail(email);
		loginPage.enterPassword(password);
		
	}

	@Given("the user click on the {string} button text")
	public void the_user_click_on_the_button_text(String buttonName) {
	    loginPage.clickButtonByText(buttonName);
	}
	
	@Given("the user click on the {string} button desc")
	public void the_user_click_on_the_button_desc(String buttonName) {
	    loginPage.clickButtonByDesc(buttonName);
	}


	@Then("the user should be redirected to the glucose chart page")
	public void the_user_should_be_redirected_to_the_glucose_chart_page() {
	    loginPage.verifyGlucoseChart();
	}

	@Then("the user should see an error message saying {string}")
	public void the_user_should_see_an_error_message_saying(String message) {
	    loginPage.verifyErrorMessage(message);
	}
	
	
	@Then("the {string} button by desc should be {string}")
	public void the_button_should_be(String buttonName, String status) {
	    loginPage.verifyButtonStatusByDesc(buttonName, status);
	}
	
	@Then("the {string} button by text should be {string}")
	public void the_button_by_text_should_be(String buttonName, String status) {
	    loginPage.verifyButtonStatusByText(buttonName, status);
	}

	@Given("click the nutrisense logo")
	public void click_the_nutrisense() {
	    loginPage.clickNutrisenseLogo();
	}
	
	@Then("change the admin settings to {string}")
	public void change_the_admin_settings_to(String env) {
	   loginPage.changeAdminSettings(env); 
	}

}

package com.nutrisensemobile.app.steps;

import com.nutrisensemobile.app.page.RegistrationPage;
import com.nutrisensemobile.app.utility.Utility;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationSteps {
	
	RegistrationPage registrationPage = new RegistrationPage();
	
	@Then("the user click on the {string} text")
	public void user_click_on_the_text(String string) {
		registrationPage.register();
	}

	@Then("the user selects the terms and condition checkbox")
	public void select_term_and_condition_checkbox() {
		registrationPage.selectTermAndConditionCheckbox();
	}

	@Then("the user enters a first name as {string}")
	public void user_enters_the_first_name(String firstName) {
		registrationPage.enterFirstName(firstName);
	}    

	@Then("the user enters the lastName as {string}")
	public void user_enters_the_last_name(String lastName) {
		registrationPage.enterLastName(lastName);
	}

	@Then("the user enters an email as {string}")
	public void user_enters_the_email(String email) {
		if(email.equalsIgnoreCase("random")) {
			email = "swaraj-test+" + Utility.generateRandomString() + "@nutrisense.io";
		}
		registrationPage.enterEmail(email);
	}

	@Then("the user enters a password as {string}")
	public void user_enters_the_password(String password) {
		registrationPage.enterPassword(password);
	}

	@Then("the user see the {string} button is disabled")
	public void the_user_see_the_button_is_disabled(String string) {
	   registrationPage.verifyButtonIsDisabled(string, "disabled");
	}
/*	
	@Then("the user should naviagate to {string} screen")
	public void the_user_should_naviagate_to_screen(String string) {
		registrationPage.verifyScreen(string);//
	}
*/

	@Then("the user should naviagate to Select CGM screen")
	public void the_user_should_naviagate_to_select_cgm_screen() {
		registrationPage.verifyScreen();
	}

	@Then("user should see an error message saying {string}")
	public void user_should_see_an_error_message_saying(String string) {
		registrationPage.verifyErrorMessage(string);
	}
	
	@When("the user enters {string} in the Password field")
	public void the_user_enters_in_the_password_field(String string) {
		registrationPage.enterPassword(string);
	}

	@Then("the password strength should show as {string}")
	public void the_password_strength_should_show_as(String string) {
		registrationPage.verifyPasswordStrength(string);
	}




}



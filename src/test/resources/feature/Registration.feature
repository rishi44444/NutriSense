@registers
Feature: User Registration

  Background: 
    Given user click on skip button from landing screen
    And click the nutrisense logo
    Then change the admin settings to "Staging"
    And the user click on the "Log In" button text
    When the user click on the "Register" text
    And the user click on the "Sign Up with Email" button text
    And the user selects the terms and condition checkbox
    And the user scroll the screen to the bottom

  Scenario Outline: Registration with <Name>
    And the user enters a first name as "<FirstName>"
    And the user enters the lastName as "<LastName>"
    And the user enters an email as "<Email>"
    And the user enters a password as "<Password>"
    Then the "Create Account" button by text should be "<Status>"

    Examples: 
      | Name            | FirstName | LastName | Email                          | Password   | Status   |
      | Empty FirstName |           | sas      | swaraj-test@nutrisense.io      | Asdfg12345 | disabled |
      | Empty LastNAME  | Monty     |          | swaraj-test@nutrisense.io      | Asdfg12345 | disabled |
      | Empty Email     | Naruto    | gngb     |                                | Asdfg12345 | disabled |
      | Empty Password  | Suna      | hh       | swaraj-test@nutrisense.io      |            | disabled |
 
  Scenario: Create account button is enabled when all fields are entered
    And the user enters a first name as "Rony"
    And the user enters the lastName as "jhkb"
    And the user enters an email as "swaraj-test+qa7755@nutrisense.io"
    And the user enters a password as "Abcde12345"
    Then the "Create account" button by desc should be "enabled"
    
  @valid_registration
  Scenario: Register new user with valid details should be successful
  	And the user enters a first name as "Swaraj"
    And the user enters the lastName as "QA"
    And the user enters an email as "swaraj-test+qa4883@nutrisense.io"
    And the user enters a password as "Abcde12345"
    Then the user click on the "Create Account" button text
    Then the user should naviagate to Select CGM screen
  
  @registration_existing_email
  Scenario: Register with existing email should throw error message
  	And the user enters a first name as "Swaraj"
    And the user enters the lastName as "QA"
    And the user enters an email as "swaraj-test@nutrisense.io"
    And the user enters a password as "Abcde12345"
    Then the user click on the "Create Account" button text
		Then user should see an error message saying "Member with this email already exists!"
		
	@meetOneCriteria
	Scenario Outline: Password meet only one criteria
		When the user enters "<Password>" in the Password field
		Then the password strength should show as "Password Strength: <Strength>"
		Examples:
		|Password    |Strength  |
		|Dhf12       |Weak      |
		|Password!   |Good      |
		|Password123!|Awesome   |
		
  

@Login
Feature: login feature

  Background: 
    Given user click on skip button from landing screen
    And click the nutrisense logo
    Then change the admin settings to "Staging"
    And the user click on the "Log In" button text

  @valid_login
  Scenario: Verify error message displays when user eneters wrong email & password
    And the user enters a valid email "abc@email.com" and password "Abvde12345"
    Then the "Sign In" button by desc should be "enabled"
    And the user click on the "Sign In" button desc
    Then the user should see an error message saying "Incorrect email/password!"

  @invalid_login
  Scenario Outline: Verify login button is disabled when all fields are not entered
    And the user enters a valid email "<Email>" and password "<Password>"
    Then the "Log In" button by text should be "<Status>"

    Examples: 
      | Email         | Password   | Status   | 
      |               | Abcde12345 | disabled | 
      | abc@email.com |            | disabled | 
      
  @invalid_login
  Scenario Outline: Verify login button is disabled when all fields are not entered
    And the user enters a valid email "<Email>" and password "<Password>"
    Then the "Sign In" button by desc should be "enabled"

    Examples: 
      | Email         | Password   | Status  |    
      | abc@email.com | Abcde12345 | enabled | 

  @successful_login
  Scenario: Verify login is successful for valid user details
    And the user enters a valid email "swaraj-test+qa000@nutrisense.io" and password "Asdfg12345"
    And the user click on the "Sign In" button desc
    Then the user should be redirected to the glucose chart page

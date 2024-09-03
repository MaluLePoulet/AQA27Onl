@gui
Feature: Validation of login functionality

  Background:
    Given open login page

  @smoke
  Scenario: Successful login
    When login with username yanazhdanova.hey0@gmail.com and password Qwerty_1
    Then dashboard page is displayed

  Scenario: Login with incorrect password
    When set username "yanazhdanova.hey0@gmail.com"
    * set password "Qwerty_11"
    * user clicks login button
    Then error message "Email/Login or Password is incorrect. Please try again." is displayed

  Scenario: Login with incorrect username
    When set username "yanazhdanova1.hey0@gmail.com"
    * set password "Qwerty_1"
    * user clicks login button
    Then error message "Email/Login or Password is incorrect. Please try again." is displayed
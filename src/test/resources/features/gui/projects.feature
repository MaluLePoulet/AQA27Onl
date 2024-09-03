@gui
Feature: Validation of add project functionality

  Background:
    Given open login page
    * login with username yanazhdanova.hey0@gmail.com and password Qwerty_1

  Scenario: Check Add Project page
    When user clicks add project button
    Then add project page is displayed
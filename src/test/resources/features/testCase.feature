Feature: CRUD tests for Test Cases

  Scenario: Create, Read, Update, Delete Test Case
  #  Given open login page
    #  * login with username yanazhdanova.hey0@gmail.com and password Qwerty_1 // через mvn clean test эти строки не нужны
    * aerodynamic rubber car project is open
    When user clicks add test case button
    Then add test case page is open
    When user creates test case with
      | title           | Title            |
      | template        | Test Case (Text) |
      | type            | Acceptance       |
      | priority        | Low              |
      | automation type | Ranorex          |
      | preconditions   | Preconditions    |
      | steps           | Steps            |
    Then created test case page is open
    * message "Successfully added the new test case. Add another" is displayed
    When user clicks edit test case button
    Then created test case is
      | title           | Title            |
      | template        | Test Case (Text) |
      | type            | Acceptance       |
      | priority        | Low              |
      | automation type | Ranorex          |
      | preconditions   | Preconditions    |
      | steps           | Steps            |
    When user updates test case to
      | title           | Title1           |
      | template        | Test Case (Text) |
      | type            | Automated        |
      | priority        | Medium           |
      | automation type | None             |
      | preconditions   | Preconditions1   |
      | steps           | Steps1           |
    Then message "Successfully updated the test case." is displayed
    Given user clicks edit test case button
    When user clicks delete this test case button
    * user clicks delete permanently button
    Then message "Successfully deleted the test case." is displayed
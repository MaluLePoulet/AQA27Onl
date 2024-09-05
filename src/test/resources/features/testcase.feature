Feature: CRUD tests for Test Cases

  Scenario: Create, Read, Update, Delete Test Case
    Given open login page
    * login with username yanazhdanova.hey0@gmail.com and password Qwerty_1
    * aerodynamic rubber car project is open
    When user clicks add test case button
    Then add test case page is open
    When user creates test case with
      | title | template            | type       | priority | automation type | preconditions | steps |
      | Title | Exploratory Session | Functional | Low      | Ranorex         | Preconditions | Steps |

    Then created test case page is open
    * message "Successfully added the new test case." is displayed
    When user clicks edit test case button
    Then created test case is
    When user updates test case to
      | title  | template                     | type       | priority | automation type | preconditions  | steps  |
      | Title  | Exploratory Session          | Acceptance | Low      | Ranorex         | Preconditions  | Steps  |
      | Title1 | Behaviour Driven Development | Automated  | Medium   | None            | Preconditions1 | Steps1 |

    * user clicks save test case button
    Then message "Successfully updated the test case." is displayed


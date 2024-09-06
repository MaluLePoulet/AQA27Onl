Feature: CRUD test for Milestones

  Scenario: Create Milestone
    Given open login page
    * login with username yanazhdanova.hey0@gmail.com and password Qwerty_1
    * aerodynamic rubber car project is open
    When user clicks add milestone button on the sidebar
    Then add milestone page is open
    When user sets name "Milestone"
    * user sets references "References"
    * user sets description "Description"
    * user removes milestone completed checkbox
    * user clicks save milestone button
    Then message "Successfully added the new milestone." is displayed
    * milestone with name "Milestone" is displayed in the open milestones list

  Scenario: Read Milestone
    Given user clicks on created milestone
    When user clicks on edit milestone button
    Then name is "Milestone"
    * reference is "References"
    * description is "Description"
    * milestone completed checkbox is removed

  Scenario: Update Milestone
    When user sets name "Milestone1"
    * user sets references "References1"
    * user sets description "Description1"
    * user clicks save milestone button
    Then message "Successfully updated the milestone." is displayed

  Scenario: Delete Milestone
    Given user clicks milestone button on the top panel
    When user clicks delete milestone button and confirms deletion
    Then message "Successfully deleted the milestone (s)." is displayed
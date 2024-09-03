Feature: Использование Background and Rules

  Rule: Rule 1

    Background:
      Given открыт браузер
      * страница логина открыта

    Scenario: scenario 1
      When user "yanazhdanova.hey0@gmail.com" with password "Qwerty_1" logs in
      Then page title is "All Projects"
      And project ID is 123

    Scenario: scenario 2
      When user "yanazhdanova1.hey0@gmail.com" with password "Qwerty_1" logs in
      Then error "Error Message" is displayed

  Rule: Rule 2

    Background:
      Given открыт браузер
      * страница логина открыта

    Scenario: scenario 1
      When user "yanazhdanova.hey0@gmail.com" with password "Qwerty_1" logs in
      Then page title is "All Projects"
      And project ID is 123

    Scenario: scenario 2
      When user "yanazhdanova1.hey0@gmail.com" with password "Qwerty_1" logs in
      Then error "Error Message" is displayed

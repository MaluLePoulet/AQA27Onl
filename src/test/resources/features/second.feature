Feature: Параметризированные тесты

  Scenario: Параметризация шагов (степов)
    Given открыт браузер
    * страница логина открыта
    When user "yanazhdanova.hey0@gmail.com" with password "Qwerty_1" logs in
    Then page title is "All Projects"
    And project ID is 123
    And project ID is "123"
    And project ID equals 123
    And all elements are visible
    And all elements are not visible
    And all elements "are" visible
    And all elements "are not" visible

  Scenario Outline: Параметризация с использованием таблицы значений
    Given открыт браузер
    * страница логина открыта
    When user "<username>" with password "<password>" logs in
    Then project ID is <projectID>

    Examples:
      | username                     | password | projectID |
      | yanazhdanova.hey0@gmail.com  | Qwerty_1 | 123       |
      | yanazhdanova1.hey0@gmail.com | Qwerty_1 | 124       |
      | yanazhdanova2.hey0@gmail.com | Qwerty_1 | 125       |

  Scenario: Параметризация шага с большим количеством данных
    Given открыт браузер
    * страница логина открыта
    When user logged in with
      | username | yanazhdanova.hey0@gmail.com |
      | password | Qwerty_1                    |
      | age      | 26                          |
      | sex      | F                           |
    Then page title is "All Projects"
    Then project ID is 123

  Scenario: Параметризация шага с большим количеством данных в одном шаге
    Given открыт браузер
    * страница логина открыта
    When user logged in with 1
      | username                     | password | age | sex |
      | yanazhdanova.hey0@gmail.com  | Qwerty_1 | 26  | F   |
      | yanazhdanova1.hey0@gmail.com | Qwerty_2 | 27  | M   |

    Then page title is "All Projects"
    Then project ID is 123



Feature: Expense

  Scenario: Present no expenses
    Given no expenses
    Given user "User"
    When user "User" logged in
    Then no expenses will be presented to the user "User"

  Scenario: Present user expenses
    Given user "User"
    Given "User" user expenses
      | date | amount |
      | 2014-12-11 | 10.0 |
      | 2014-12-13 | 20.0 |
      | 2014-12-12 | 30.0 |
    When user "User" logged in
    Then the following expenses will be presented to the user "User" in order
      | date | amount |
      | 2014-12-13 | 20.0 |
      | 2014-12-12 | 30.0 |
      | 2014-12-11 | 10.0 |

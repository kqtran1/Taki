Feature: Expense

  Scenario: Present no expenses
    Given no expenses
    Given user "User"
    When user "User" logged in
    Then no expenses will be presented to the user "User"
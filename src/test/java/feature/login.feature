@Login
Feature: Login

  Scenario: User login successfully
    When user login with valid credentials "TC001"
    Then the product page should displayed

  Scenario: Locked out user login
    When user login with valid credentials "TC002"
    Then the locked out error message "Epic sadface: Sorry, this user has been locked out." should displayed

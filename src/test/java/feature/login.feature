@Login
Feature: Login

  Scenario: User login successfully
    When user login with valid credentials "StandardUser"
    Then the product page should displayed

  Scenario: Locked out user login
    When user login with valid credentials "LockedOutUser"
    Then the locked out error message "Epic sadface: Sorry, this user has been locked out." should displayed

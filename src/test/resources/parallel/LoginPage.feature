Feature: Login Page feature

  Background: 
    Given user is on the login page

  @login
  Scenario: Check login page title
    When user checks the login page title
    Then the page title should be "Account Login"

  @login
  Scenario: Check login page URL
    Then the URL should contain "account/login"

  @login
  Scenario: Check forgot password link existence
    Then the forgot password link should be displayed

  @login
  Scenario: Login to application
    When the user logs in with username "testing_demo@gmail.com" and password "test@123"
    Then the user should be redirected to the accounts page with title "My Account"

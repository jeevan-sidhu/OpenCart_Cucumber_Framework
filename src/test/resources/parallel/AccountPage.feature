Feature: Account Page feature

  Scenario: Check Account page title
    Given user is on the Account page
    When user checks the account page title
    Then the account page title should be "My Account"

Feature: Account Page feature

  Background: 
    Given user is on the Account page

  @accounts
  Scenario: Check Account page title
    When user checks the account page title
    Then the account page title should be "My Account"

  @accounts
  Scenario: Verify the headers on the accounts page
    When the user checks the page headers
    Then the page headers should be:
      | My Account           |
      | My Orders            |
      | My Affiliate Account |
      | Newsletter           |

  @accounts
  Scenario Outline: Verify the search functionality on the accounts page
    When the user searches for "<searchKey>"
    Then the result count should be <resultsCount>

    Examples: 
      | searchKey | resultsCount |
      | macbook   |            3 |
      | imac      |            1 |
      | samsung   |            2 |
      | tshirt    |            0 |

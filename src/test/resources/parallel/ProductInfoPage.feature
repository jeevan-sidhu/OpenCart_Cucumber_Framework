Feature: Product Info Page feature

  Background: 
    Given user is on the Account page

  @product
  Scenario Outline: Verify the search and product selection functionality
    When the user searches for "<searchKey>"
    And user selects the product "<productName>"
    Then the slected product should be "<productName>"

    Examples: 
      | searchKey | productName              |
      | macbook   | MacBook Pro              |
      | macbook   | MacBook Air              |
      | imac      | iMac                     |
      | samsung   | Samsung SyncMaster 941BW |
      | samsung   | Samsung Galaxy Tab 10.1  |

  @product
  Scenario: Verify the product information
    When the user searches for "macbook"
    And user selects the product "MacBook Pro"
    Then the product information should be:
      | productheader | MacBook Pro  |
      | Brand         | Apple        |
      | Product Code  | Product 18   |
      | Reward Points |          800 |
      | Availability  | Out Of Stock |
      | productprice  | $2,000.00    |
      | extaxprice    | $2,000.00    |

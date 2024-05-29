Feature: AmazonTest

  Scenario: Adding a “Monitor” Item in Cart and verifying sub total
  Given User is on "https://www.amazon.in" url on main page
    And User will search "Monitor" in search field
    And User will click on "1" st item from the list
    And User will get price of item "1" on product page
    And User will click on "Cart" button
    And User will get price of item "1" on cartPage
    Then User will verify prices
    Then User will verify Subtotal on Product and Cart Page
    Then User will close browser

  Scenario: Adding a “Laptop” Item in Cart and verifying sub total
    Given User is on "https://www.amazon.in" url on main page
    And User will search "Laptop" in search field
    And User will click on "2" st item from the list
    And User will get price of item "2" on product page
    And User will click on "Cart" button
    And User will get price of item "2" on cartPage
    Then User will verify prices
    Then User will verify Subtotal on Product and Cart Page
    Then User will close browser

  Scenario: Adding two items in Cart and verifying sub total
    Given User is on "https://www.amazon.in" url on main page
    And User will search "Headphones" in search field
    And User will click on "1" st item from the list
    And User will get price of item "1" on product page
    And User will search "Keyboard" in search field
    And User will click on "1" st item from the list
    And User will get price of item "1" on product page
    And User will click on "Cart" button
    And User will get price of item "1" on cartPage
    Then User will verify prices
    Then User will verify Subtotal on Product and Cart Page
    Then User will close browser






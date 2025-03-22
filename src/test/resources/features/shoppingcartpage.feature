# shoppingcartpage.feature
Feature: Shopping Cart Functionality

  Scenario: Verify shopping cart operations
    Given I am on the home page for shopping cart testing
    When I search for "smartphone" and add the product to cart
    When I go to the shopping cart
    When I remove the product from cart
    Then the shopping cart is empty
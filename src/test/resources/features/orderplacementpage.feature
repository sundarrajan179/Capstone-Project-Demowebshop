# orderplacementpage.feature
Feature: Order Placement Functionality

  Scenario: Place an order as a guest
    Given I am on the home page for order placement testing
    When I add a product to cart and proceed to checkout as guest
    When I fill in billing and shipping details
    When I complete the payment process
    Then the order should be successfully placed
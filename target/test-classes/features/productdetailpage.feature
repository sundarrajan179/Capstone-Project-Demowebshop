# productdetailpage.feature
Feature: Product Detail Page Verification

  Scenario: Verify product details and add to wishlist/cart
    Given I am on the home page for product detail testing
    When I search for "Smartphone" and click the product link
    Then the product name contains "Smartphone"
    Then the product description is "Newest Tricentis smartphone"
    Then the product price is "100.00"
    When I click the add to wishlist button
    When I click the add to cart button
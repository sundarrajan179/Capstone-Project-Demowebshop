# searchpage.feature
Feature: Search Functionality

  Scenario: Perform advanced search
    Given I am on the home page
    When I enter "phone" in the search box and click search
    When I click the advanced search checkbox
    When I select "Computers" from the category dropdown
    When I enter price range from "100" to "200"
    When I click the search result button
    Then search results should be displayed
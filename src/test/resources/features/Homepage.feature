@HomePage
Feature: Home Page Verification

  @VerifyTitleAndSections
  Scenario: Verify the title and major sections of the Home Page
    Given I open the browser and navigated to home page
    Then check the page have "offer for you" section
    Then check the page have "recomended" section
    Then the search bar should be available
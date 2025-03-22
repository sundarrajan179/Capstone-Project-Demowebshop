@InvalidLogin
# invalidlogincredentialspage.feature

Feature: Invalid Login Credentials Functionality

  Scenario: Verify error message for invalid login
    Given I am on the home page for invalid login testing
    When I navigate to the login page and enter invalid credentials
    Then I should see an error message for invalid login
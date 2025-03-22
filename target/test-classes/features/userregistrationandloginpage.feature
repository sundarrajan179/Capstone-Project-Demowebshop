Feature: User Registration and Login Functionality

  @Register
  Scenario Outline: Successful Registration with valid credentials
    Given I am on the home page for user registration and login testing
    Then the user clicks on the register link
    Then the registration page is displayed on the screen
    When the user enters "<firstName>" and "<lastName>" and "<email>" and "<password>" and "<confirmPassword>"
    When the user clicks the signup button
    Then the user sees the My Courses page
    When the user clicks the Logout

    Examples:
      | firstName      | lastName | email                         | password | confirmPassword |
      | jack      | will     | hshewhqh22121@gmail.com | hshewhqh22121 | hshewhqh22121       |
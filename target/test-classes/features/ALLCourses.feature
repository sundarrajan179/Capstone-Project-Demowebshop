@AllCourses
Feature: All Courses Page

  @FilterCategory
  Scenario: Filter courses by category
    Given I am on the All Courses Page
    When I filter courses by category "Sotfware Testing"
    Then I should see the course "Selenium WebDriver 4 With Java" by category

  @SearchCourse  
  Scenario: Search for a course
    Given I am on the All Courses Page
    When I search for the course "JavaScript"
    Then I should see the course "Cypress.io Test Automation" by searching

@users @smoke @logout
Feature: logout user

  Scenario: Should be able to logout from the application
    Given Sam is logged into the application
    When Sam requested the logout service
    Then he should exit the app
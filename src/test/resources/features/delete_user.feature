@users @smoke @deleteuser
Feature: delete user

  Scenario: Should be able to delete a user
    Given Sam is logged into the application
    When Sam requested the delete user service
    Then he should see the user was deleted successfully
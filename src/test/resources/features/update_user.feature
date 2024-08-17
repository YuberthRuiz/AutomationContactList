@users @smoke @updateuser
Feature: update user

  Scenario: Should be able to update a user
    Given Sam is logged into the application
    When Sam requested the update user service
    Then he should see the updated user successfully response
@users @smoke @newuser
Feature: Add new user
  To make smoke testing
  As a contact list app user
  I want to be able to create new users

  Scenario: Should be able to create new users when the user logs in
    Given Sam is logged into the application
    When he requested the add user service
    Then he should see user created successfully
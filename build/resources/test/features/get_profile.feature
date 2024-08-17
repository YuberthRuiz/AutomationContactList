@contacts @smoke @getprofile
Feature: Get my profile

  Scenario: Should be able to get the profile information
    Given Sam is logged into the application
    And Sam requested the profile service
    Then he should see the profile response successfully


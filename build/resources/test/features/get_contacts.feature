@contacts @smoke @list
Feature: Get the contacts list

  Scenario: Should be able to get contacts list
    Given Sam is logged into the application
    When Sam requested the list of contacts
    Then he should see a successfully request response


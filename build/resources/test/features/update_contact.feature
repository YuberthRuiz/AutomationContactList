@contacts @update
Feature: Update a new contact information

  Scenario: Should be able to update the contact information
    Given Sam is logged into the application
    And Sam requested the add contact service
    And he should see the contact created successfully
    When Sam try to update the contact
    Then he should see a successfully response


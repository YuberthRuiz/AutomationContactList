@contacts @delete
Feature: Delete a contact

  Scenario: Should be able to delete the contact
    Given Sam is logged into the application
    And Sam requested the add contact service
    And he should see the contact created successfully
    When Sam try to delete the contact
    Then he should see the contact was deleted


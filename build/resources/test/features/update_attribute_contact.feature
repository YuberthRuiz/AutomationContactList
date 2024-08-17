@contacts @smoke @updateattribute
Feature: Update one attribute of the contact information

  Scenario: Should be able to update just one attribute of the contact
    Given Sam is logged into the application
    And Sam requested the add contact service
    And he should see the contact created successfully
    When Sam try to update just one attribute of the contact
    Then he should see a successfully response


@contacts @smoke @contact
Feature: Get one specific contact

  Scenario: Should be able to get the recently added contact
    Given Sam is logged into the application
    And Sam requested the add contact service
    #And he should see the newly created contact
    When Sam requested the contact service
    Then he should see the contact requested was successfully


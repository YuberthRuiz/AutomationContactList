@contacts @smoke @newcontact
Feature: Add new contact
  To make smoke testing
  As a contact list app user
  I want to be able to create new contacts

  Scenario: Should be able to create new contacts when the user logs in
    Given Sam is logged into the application
    When Sam requested the add contact service
    Then he should see the contact created successfully
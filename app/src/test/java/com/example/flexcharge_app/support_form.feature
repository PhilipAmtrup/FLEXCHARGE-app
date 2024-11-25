Feature: Submit Support Request
  As a user
  I want to submit a support request
  So that I can get help with my issue

  Scenario: Successful submission of a support request
    Given I am on the support form page
    When I enter a valid email "user@example.com"
    And I enter a valid phone number "12345678"
    And I enter a valid problem description "My charger is not working"
    And I click the submit button
    Then I should see a success message "Your support request was submitted successfully!"

  Scenario: Submission with missing email
    Given I am on the support form page
    When I leave the email field blank
    And I enter a valid phone number "12345678"
    And I enter a valid problem description "My charger is not working"
    And I click the submit button
    Then I should see an error message "Email cannot be empty."

  Scenario: Submission with missing problem description
    Given I am on the support form page
    When I enter a valid email "user@example.com"
    And I enter a valid phone number "12345678"
    And I leave the problem description blank
    And I click the submit button
    Then I should see an error message "Problem description cannot be empty."

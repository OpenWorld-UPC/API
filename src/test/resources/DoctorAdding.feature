Feature: Doctor Adding
  As a Developer
  I want to add Doctor through API
  So that It can be available to applications

  Background:
    Given the Endpoint "http://localhost:%d/api/v1/doctors" is available

    @doctor-adding
    Scenario:  Add Doctor
      When a Doctor Request is sent with values "BDD Best Practices", "A summary with the best practices for making BDD Tests.", "In the article we will explaining the 10 best practices for working with BDD Tests."
      Then a Response with Status 200 is received
      And a Doctor Resource with values "BDD Best Practices", "A summary with the best practices for making BDD Tests.", "In the article we will explaining the 10 best practices for working with BDD Tests." is included in Response Body

      @doctor_duplicated
      Scenario: Add Doctor with existing Name
        Given A Doctor Resource with values "BDD Best Practices", "A summary with the best practices for making BDD Tests.", "In the article we will explaining the 10 best practices for working with BDD Tests." is already stored
        When a Doctor Request is sent with values "BDD Best Practices", "A summary with the best practices for making BDD Tests.", "In the article we will explaining the 10 best practices for working with BDD Tests."
        Then a Response with Status 400 is received
        And Message with value "A Doctor with the same name already exits." is included in Response Body

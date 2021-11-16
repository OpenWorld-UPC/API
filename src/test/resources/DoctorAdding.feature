Feature: Doctor Adding
  As a Developer
  I want to add Doctor through API
  So that It can be available to applications

  Background:
    Given the Endpoint "http://localhost:%d/api/v1/doctors" is available

    @doctor-adding
    Scenario:  Add Doctor
      When a Doctor Request is sent with values "Enzo", 50, "photo url", "doctor description", "doctor workplace", "doctor specialty", 3
      Then a Response with Status 200 is received
      And a Doctor Resource with values "Enzo", 50, "photo url", "doctor description", "doctor workplace", "doctor specialty", 3 is included in Response Body


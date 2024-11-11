# Language: en
# Author: Team Calidad

Feature: Create a new subject
  As an administrator user of the portal, I want to register a new subject
  by providing the subject details so it is available in the system.

  Scenario: The user creates a subject while logged in with valid data
    Given the user is authenticated to post a subject
    When the user submits the details of a new subject
    Then the system should respond with an HTTP status 200
    And the response should contain the id "testid" and the name "test name"

  Scenario: The user attempts to create a subject without being logged in
    Given the user is not authenticated to post a subject
    When the user submits the details of a new subject
    Then the system should respond with an HTTP status 401

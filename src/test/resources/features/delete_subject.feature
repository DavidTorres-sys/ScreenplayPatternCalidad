# Language: en
# Author: Team Calidad

Feature: Delete a subject
  As an administrator user of the portal, I want to delete a subject.

  Scenario: The user successfully deletes a course
    Given the user is authenticated on the Toolbox platform
    When the user requests to delete the course with id "testid"
    Then the system should confirm the deletion with an HTTP status 204

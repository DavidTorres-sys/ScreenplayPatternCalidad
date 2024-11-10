# Language: en
# Author: Team Calidad

Feature: Consult subject information
  As a user of the portal, I want to consult information
  related to the subject in the Systems Engineering program
  to obtain specific details of each course.

  Scenario: The user searches for information on all subject
    Given the user is logged into the Toolbox platform
    When the user searches for subjects without any filter
    Then the system responds with a list containing information on all subjects

  Scenario: The user searches for an existing subject by its code
    Given the user is logged into the Toolbox platform
    When the user enters the subject code "l1"
    Then the system responds with detailed information about the subject

  Scenario: The user searches for a non-existent subject by code
    Given the user is logged into the Toolbox platform
    When the user enters the subject code "IS999"
    Then the system responds by informing that the subject does not exist

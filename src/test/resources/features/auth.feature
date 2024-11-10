# Language: en
# Author: Team Calidad

Feature: Authenticate
  As a user of the portal, I want to log in
  to perform actions that require authentication.

  Scenario: The user authenticates with valid credentials
    Given the user is on the login page
    When the user enters a valid username and password
    Then the system responds with an acceptance code and a token

  Scenario: The user authenticates with invalid credentials
    Given the user is on the login page
    When the user enters an invalid username and password
    Then the system responds with a rejection code due to unauthorized access

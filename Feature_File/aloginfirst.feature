@Login
Feature: feature to test login funcationality

  Scenario Outline: Check login with valid details
    Given user is on login page
    When user enters <username> and <password>
    And clicks on login button
    Then user is navigated to home page

    Examples: 
      | username                    | password        |
      | username                    | password        |

  Scenario Outline: Check login with invalid details
    Given user is inside login page
    When user enter his <name> and <passw>
    And user click on button
    Then User is not allowed to logg in

    Examples: 
      | name             | passw  |
      | username@gmail.com | pass |

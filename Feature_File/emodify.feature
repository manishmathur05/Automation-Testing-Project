@Modify
Feature: Checking of Modified Data

Background:
Given user login

Scenario: Last values modified
Given user has already logged in
Then user clicks on company and goes to last page
Then user modifies the values
And user finds modified values 

Scenario: Last values not modified
Given already logged in webpage
Then user clicks on company and goes to end
And user does not find modified values 
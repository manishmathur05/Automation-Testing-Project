@Checkmobile
Feature: Checkting Total Number Of Mobiles Present

Background:
Given login by user into website

Scenario: Checking Total mobile
Given user alread inside
Then user navigate to last page
And user findes nine mobile


Scenario: Check mobile negative
Given user inside page
Then user goes to page
And user findes ten mobiles

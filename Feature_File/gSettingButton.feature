@Settings
Feature: Checking Different Parts Of Settings Button

Background:
Given user will login the website

Scenario: Setting Button Presence
Given user has logged inside website
And user hovers to right cornor of webpage 
Then user finds settings button

Scenario: Setting Button Absent
Given user has logged in
And user goes right cornor of webpage
Then does not finds button

Scenario: Presence Of Multiple option in Settings Button
Given user login done
And user clicks settings button
Then user finds all five options

Scenario: Absence Of  option in Settings
Given user has alredy logged in
And user click settings icon
Then user does not find some options

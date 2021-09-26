# Author - Luciano Lemos
# Date - 2021-09-25

Feature: Testing contact form

  Scenario: Check successful contact submission
  
    Given user on contact form
    When user fullfill provides value to fields
    And clicks on Submit button
    Then Messege sent succesfully
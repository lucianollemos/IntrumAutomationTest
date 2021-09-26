# Author - Luciano Lemos
# Date - 2021-09-25
# encoding: utf-8

Feature: Testing contact form

#  Scenario Outline: Check successful contact submission
  
#    Given user on contact form
#    When user provides valid value to fields <name>, <personal_code>, <case_number>, <phone>, <email>, <address> and <objection>
#    And clicks on submit button
#    Then messege sent succesfully
    
#    Examples:
#			| name | personal_code | case_number | phone | email | address | objection |
#			|  |  |  |  |  |  |  |
			
	Scenario Outline: Check validation of required fields
	
		Given user on contact form
    When user clicks on submit button without provide value to required fields
    Then Validation <message> should be shown for every required field
    
    Examples:
    	| message |
    	| Lūdzu, aizpildiet lauku |
# Author - Luciano Lemos
# Date - 2021-09-25
# encoding: utf-8

Feature: Testing contact form

  Scenario Outline: Check successful contact submission
  
  	Given user on contact form
		And user provides valid value to fields <name>, <personal_code>, <case_number>, <phone>, <email>, <address>, <objection> and <answerType>	
		When clicks on submit button
		Then messege sent succesfully
    
   Examples:
			| name | personal_code | case_number | phone | email | address | objection | answerType |
			| Name sample | personal code sample | 12345 | 00 000-000-000 | email@sample.com | address sample | objection sample | E-pasts |
			| Name sample | personal code sample | 12345 | 00 000-000-000 | email@sample.com | address sample | objection sample | Pasts |
	
	@run		
	Scenario Outline: Check validation of required fields
	
		Given user on contact form
    When user clicks on submit button without provide value to required fields
    Then Validation <message> should be shown for every required field
    
    Examples:
    	| message |
    	| Lūdzu, aizpildiet lauku |
  
  @run
  Scenario Outline: Check format validation on email field
  
  	Given user on contact form
  	And user insert an invalid <email>
  	When clicks on submit button
  	Then Validation <message> should be shown for email field
  	
  	Examples:
  		| email | message |
  		| invalidemail.com | some validation message |

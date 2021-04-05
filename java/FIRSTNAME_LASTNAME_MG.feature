  Feature: Sign up page - validation of fields
	  As a candidate casino player
	  I need to register with a valid data
	  So that i can play casino games 	

  Background: Opening the browser and navigating to the casino site
		Given I open some brower
		And I navigate to https://moneygaming.qa.gameaccount.com/sign-up.shtml
  
  Scenario: Sign up with valid password 
    # at least 6 characters long with at least 1 number and at least one special charakter 
    Given https://moneygaming.qa.gameaccount.com/sign-up.shtml is opened
    When I type "kiko1&" in "Choose Password" field 
    Then I do Not see an error message under "Choose Password" field 
 
  Scenario Outline: Try to sign up with not allowed lenght for password
    Given https://moneygaming.qa.gameaccount.com/sign-up.shtml is opened
    When I type <password> in "Choose Password" field 
    Then I see the error message "The minimum length is 6 characters" under "Choose Password" field 
 
 	  Examples:
 	  |password|     
 	  |lol1#|

  Scenario Outline: Try to sign up with password with missing letter, number or special charakter in it
    Given https://moneygaming.qa.gameaccount.com/sign-up.shtml is opened
    When I type <password> in "Choose Password" field 
    Then I see the error message "....." under "Choose Password" field 
    # to be navigated in analyses for concrete error message
 
 	  Examples:
 	  |password|
 	  |123456@|
 	  |pipip!|
 	  |miminos7|

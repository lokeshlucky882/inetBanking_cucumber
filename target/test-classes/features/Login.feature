Feature: Login feature

	Background: Below are the common steps for all the Scensrios
	
		Given User launch chrome browser
    When User opens URL as "http://demo.guru99.com/V2/"
	
	@smoke
  Scenario: Login with User credentials
    
    And User login with Username as "mngr266311" and Password as "YvuzYtY"
    And click on Login button
    Then the Page title is displayed as "Guru99 Bank Manager HomePage"
    And User close the browser

	@sanity
	Scenario Outline: Login with Data Driven User credentials
   
    And User login with Username as "<Email>" and Password as "<Password>"
    And click on Login button
    Then the Page title is displayed as "Guru99 Bank Manager HomePage"
    And User close the browser

    Examples: 
      | Email  | Password |
      | mngr266311 | YvuzYtY |
      | mngr266311 | YvuzYtY |
 

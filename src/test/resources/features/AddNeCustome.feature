Feature: Add new customer

Background: Below are the common steps for all the Scensrios
	
		Given User launch chrome browser
    When User opens URL as "http://demo.guru99.com/V2/"
	
	@regression
  Scenario: Add new customer
    
    And User login with Username as "mngr266311" and Password as "YvuzYtY"
    When click on Login button
    Then the Page title is displayed as "Guru99 Bank Manager HomePage"
    When User click on NewCustomer button
    Then the Page title is displayed as "Guru99 Bank New Customer Entry Page"
    And User fill the Add new customer form
    When User click on Submit button
    Then New Customer is created with id
    And User close the browser

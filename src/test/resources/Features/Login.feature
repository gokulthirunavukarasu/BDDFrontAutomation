Feature: Validating Hireprous login page

  #Scenario-1
  @SmokeTest
  Scenario: Login to application with valid user credentials
    Given User is on Hireprous login page
    When User enters username and password
    And User clicks on Log IN button
    Then User login must be successful

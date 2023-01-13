#------------------------------------------------------------------------------------
# Authors : Nagesh/Kasthuri                               Reviewed By:Gokul
# Date : 14/01/2023                                     Reviewed On: 
# Last Updated By:
# Last Updated On:
# Feature Name: Login to NP Page
# Feature Description: Login to NP website with the username and password
#------------------------------------------------------------------------------------
Feature: F01_Validating Nop login page

  #Scenario-1
  @SmokeTest
  Scenario: Login to application with valid user credentials
    Given User is on Hireprous login page
    When User enters username and password
    And User clicks on Log IN button
    Then User login must be successful

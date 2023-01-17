#------------------------------------------------------------------------------------
# Authors : Nagesh/Kasthuri                               Reviewed By:Gokul
# Date : 14/01/2023                                     Reviewed On:
# Last Updated By:
# Last Updated On:
# Feature Name: F02_Create Customer
# Feature Description: Creating Customer
#------------------------------------------------------------------------------------
Feature: F02_Create Customer

  #Scenario-1
  @SmokeTest
  Scenario: Create and Validating Customer
    Given User navigate to the Dashboard page by logging in to nopCommerce
    When User clicks on Customers tab
    And User clicks on Add new button
    And User enters data to the Customer info fields
    And User clicks on save button
    Then User will be redirected to Customers list page successfully
    And User verifies created customer in Customers list

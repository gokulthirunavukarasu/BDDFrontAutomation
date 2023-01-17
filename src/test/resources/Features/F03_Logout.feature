#------------------------------------------------------------------------------------
# Authors : Nagesh/Kasthuri                               Reviewed By:Gokul
# Date : 14/01/2023                                     Reviewed On:
# Last Updated By:
# Last Updated On:
# Feature Name: F03_Logout
# Feature Description: Logout
#------------------------------------------------------------------------------------
Feature: F03_Logout

  #Scenario-1
  @SmokeTest
  Scenario: Validating logout functionlity
     Given User navigate to the Dashboard page by logging in to nopCommerce
     When User clicks on Logout button
     Then User will be redirected to Login page successfully

@SignInTest
Feature: Retail SignIn

  Scenario: Verify user can sign in into Retail Application
    Given User is on retail website
    When User click on Sign in option
    And User enter email 'ib@tekschool.us' and password 'Ibrahim@1987'
    And User click on login button
    Then User should be logged into Account

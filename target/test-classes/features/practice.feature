Feature: practice on edit address

  Background: 
    Given User is on retail website
    When User click on Sign in option
    And User enter email 'ib@tekschool.us' and password 'Ibrahim@1987'
    And User click on login button
    And User should be logged into Account
    
    
        
@editAddress
  Scenario: Verify User can edit an Address added on account
    When User click on Account option
    And User click on edit address option
    And user fill new address form with below information
      | country       | fullName | phoneNumber | streetAddress    | apt | city       | state                | zipCode |
      | United States | Dragons  |  4756358752 | 500 Wisconsen Av | 678 | Washington | District of Columbia |   58654 |
    And User click update Your Address button
    Then a message should be displayed 'Address Updated Successfully'
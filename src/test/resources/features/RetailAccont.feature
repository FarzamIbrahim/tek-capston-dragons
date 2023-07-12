Feature: Retail Account

  Background: 
    Given User is on retail website
    When User click on Sign in option
    And User enter email 'ib@tekschool.us' and password 'Ibrahim@1987'
    And User click on login button
    And User should be logged into Account

  @createAccount
  Scenario: Verify user can create an account into Retail Website
    Given User is on retail website
    When User click on Sign in option
    And User click on Create New Account button
    And User fill the signUp information with below data
      | name           | email                   | password  | confirmPassword |
      | Ibrahim Farzam | Ibrahim110@tekschool.us | Tek@12335 | Tek@12335       |
    And User click on SignUp button
    Then User should be logged into account page

  @updateProfile
  Scenario: Verify User can update Profile Information
    When User click on Account option
    And User update Name 'Ibrahim Fa' and Phone '437-256-2289'
    And User click on Update button
    Then user profile information should be updated

  @addPaymentMethod
  Scenario: Verify User can add a payment method
    When User click on Account option
    And User click on Add a payment method link
    And User fill Debit or credit card information
      | cardNumber       | nameOnCard | expirationMonth | expirationYear | securityCode |
      | 4444888822226664 | Javid      |              10 |           2027 |          557 |
    And User click on Add your card button
    Then a message should be displayed 'Payment Method added sucessfully'

  @editPaymentMethod
  Scenario: Verify User can edit Debit or Credit card
    When User click on Account option
    And User select the card ending with '5559'
    And User click on Edit option of card section
    And user edit information with below data
      | cardNumber     | nameOnCard | expirationMonth | expirationYear | securityCode |
      | 11117777666655 | Fahim      |              12 |           2028 |          158 |
    And user click on Update Your Card button
    Then a message should be displayed 'Payment Method updated Successfully'

  @removePaymentMethod
  Scenario: Verify User can remove Debit or Credit card
    When User click on Account option
    And User select the card ending with '4443'
    And User click on remove option of card section
    Then payment details should be removed

  @addNewAddress
  Scenario: Verify User can add an Address
    When User click on Account option
    And User click on Add address option
    And user fill new address form with below information
      | country       | fullName | phoneNumber | streetAddress    | apt | city       | state                | zipCode |
      | United States | Dragons  |  4756358752 | 509 Wisconsen Av | 688 | Washington | District of Columbia |   58654 |
    And User click Add Your Address button
    Then a message should be displayed 'Address Added Successfully'

  @editAddress
  Scenario: Verify User can edit an Address added on account
    When User click on Account option
    And User click on edit address option
    And user fill new address form with below information
      | country       | fullName | phoneNumber | streetAddress    | apt | city       | state                | zipCode |
      | United States | Dragons  |  4756358723 | 504 Wisconsen Av | 687 | Washington | District of Columbia |   58548 |
    And User click update Your Address button
    Then a message should be displayed 'Address Updated Successfully'

  @removeAddressFromAccount
  Scenario: Verify User can remove Address from Account
    When User click on Account option
    And User click on remove option of Address section
    Then Address details should be removed

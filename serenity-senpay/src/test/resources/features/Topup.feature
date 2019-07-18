
Feature: Topup

Background:
     Given The user is staying login page
    When The user input valid phone number and pincode and The user click Login button
   #Scenario: The User should topup unsuccessful by BIDV
    #  Given The user choose topup by BIDV
   # When The user input valid topup amount 
   # And Input invalid OTP and click Agree button 
   # Then The user see error message
    
    Scenario: The User should topup successful by BIDV
      Given The user choose topup by BIDV
    When The user input valid topup amount 
    And Input valid OTP and click Agree button 
    Then Balance of wallet increases and Transaction has status successful
Feature: Login
@E2E
   Scenario: The User should topup success ful
    Given The user choose topup by visa
    When The user input valid card information 
    And Input OTP on cybersource
    And click Agree button
    Then Balance of wallet increases and Transaction has status successful
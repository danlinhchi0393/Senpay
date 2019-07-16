Feature: Topup
   Scenario: The User should topup success ful
   Given The user choose topup by BIDV
    When The user input valid topup amount 
    And Input OTP and click Agree button 
    Then Balance of wallet increases and Transaction has status successful
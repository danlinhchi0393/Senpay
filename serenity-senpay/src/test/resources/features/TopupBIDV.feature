
Feature: Topup by BIDV

Background:
     Given The user is staying login page
    When The user input valid phone number and pincode and The user click Login button
      
    @Normal
     Scenario: The User input invalid OTP timeout
    Given The user choose topup by BIDV
    When The user input valid topup amount 
    And Input invalid OTP timeout and click Agree button 
    Then The user see error message topup unsuccessful
  @Test
    Scenario: The User input invalid OTP for the five time / 1 transaction
    Given The user choose topup by BIDV
    When The user input valid topup amount 
    And Input invalid OTP and click Agree button 
    Then The user see error message for the first time
    And Input invalid OTP and click Agree button
    Then The user see error message for the second time
    And Input invalid OTP and click Agree button
    Then The user see error message for the third time
    And Input invalid OTP and click Agree button
    Then The user see error message for the fourth time
    And Input invalid OTP and click Agree button
    Then The user see error message for the fifth time
    Given The user choose topup by BIDV
    When The user input valid topup amount 
    And Input invalid OTP and click Agree button 
     Then The user see error message block OTP
   @Normal
    Scenario: The User should topup successful by BIDV
    Given The user choose topup by BIDV
    When The user input valid topup amount 
    And Input valid OTP and click Agree button 
    Then Balance of wallet increases and Transaction has status successful
  @Normal
    Scenario: The User enter the topup amount lower than the limit
    Given The user choose topup by BIDV
    When The user enter the topup amount lower than the limit and click Next 
    Then The user see error message about tranlimit
 @Unauthenticated
    Scenario: The User enter the topup amount greater than the limit (Unauthenticated)
    Given The user choose topup by BIDV
    When The user enter the topup amount greater than the limit and click Next 
    Then The user see error message about tranlimit
    #Error message "Giá trị tối thiểu của giao dịch là 10,000VND và tối đa là 2,000,000VND!"
 @Normal
    Scenario: The User enter the topup amount greater than the limit (Authenticated)
    Given The user choose topup by BIDV
    When The user enter the topup amount greater than the limit and click Next 
    Then The user see error message about tranlimit
    #Error message "Giá trị tối thiểu của giao dịch là 10,000VND và tối đa là 10,000,000VND!"
    
    
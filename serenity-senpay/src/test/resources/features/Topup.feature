
Feature: Topup by BIDV

Background:
     Given The user is staying login page
    When The user input valid phone number and pincode and The user click Login button
   Scenario: The User input invalid OTP for the first time
    Given The user choose topup by BIDV
    When The user input valid topup amount 
    And Input invalid OTP and click Agree button 
    Then The user see error message
    
    Scenario: The User input invalid OTP for the second time
    Given The user choose topup by BIDV
    When The user input valid topup amount 
    And Input invalid OTP and click Agree button 
    Then The user see error message
   
   Scenario: The User input invalid OTP for the third time
    Given The user choose topup by BIDV
    When The user input valid topup amount 
    And Input invalid OTP and click Agree button 
    Then The user see error message
   
    Scenario: The User should topup successful by BIDV
    Given The user choose topup by BIDV
    When The user input valid topup amount 
    And Input valid OTP and click Agree button 
    Then Balance of wallet increases and Transaction has status successful
    
    
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
    @Authenticated
    Scenario: The User enter the topup amount greater than the limit (Authenticated)
    Given The user choose topup by BIDV
    When The user enter the topup amount greater than the limit and click Next 
    Then The user see error message about tranlimit
    #Error message "Giá trị tối thiểu của giao dịch là 10,000VND và tối đa là 10,000,000VND!"
    
    
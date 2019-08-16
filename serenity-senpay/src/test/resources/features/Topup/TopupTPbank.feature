Feature: topup by VTB 

  Background: 
    Given The user is staying login page
    When The user input valid phone number "0374441716" and pincode "123456" and The user click Login button
    When Get account balance before make transactions
 @vtb 
  Scenario Outline: The User input invalid topup <amount>
   Given The user choose topup by agribank
   When The user input invalid topup <amount>
  Examples: 
    | amount |
    | abc |  

  Scenario: The User input invalid topup OTP timeout
    Given The user choose topup by ViettinBank
    When The user input valid topup "100000"
    When Input topup OTP timeout and click Agree button
    Then The user see error message finish topup transaction "Quá thời gian xác thực OTP" 
    And Status of topup transaction is "Giao dịch thất bại"
    And Account balance not change
  Scenario: The User input invalid topup OTP for the first time
    Given The user choose topup by ViettinBank
    When The user input valid topup "100000"
    And Input invalid topup OTP and click Agree button
    Then The user see error message finish topup transaction "Mã xác minh không đúng. Vui lòng nhập lại."
  	 Then Status of topup transaction is "Giao dịch thất bại"
    Then Account balance not change
    
Scenario: The User has bank account not enought balance
Given The user choose topup by ViettinBank
    When The user input valid topup "1000000"
    And Input valid topup OTP and click Agree button
    Then The user see error message finish topup transaction "xxxx"
  	 Then Status of topup transaction is "Giao dịch thất bại"
    Then Account balance not change

  Scenario: The User should topup successful by ViettinBank
    Given The user choose topup by ViettinBank
    When The user input valid topup amount
    And Input valid topup OTP and click Agree button
    Then Balance of wallet increase
    Then Status of topup transaction is "Hoàn thành"
    Then Account balance decrease
    @Unauthenticated
  Scenario: The User enter the topup amount lower than the topup limit (Unauthenticated)
    Given The user choose topup by ViettinBank
    When The user enter the topup amount "1000" lower than the topup limit and click Next
    Then The user see error message about topup tranlimit "Giá trị tối thiểu của giao dịch là 50,000VND và tối đa là 2,000,000VND!"

  @Unauthenticated
  Scenario: The User enter the topup amount greater than the topup limit (Unauthenticated)
    Given The user choose topup by ViettinBank
    When The user enter the topup amount "2000001" greater than the topup limit and click Next
    Then The user see error message about topup tranlimit "Giá trị tối thiểu của giao dịch là 50,000VND và tối đa là 2,000,000VND!"
@Authenticated
    Scenario: The User enter the topup amount lower than the topup limit (Authenticated)
    Given The user choose topup by ViettinBank
    When The user enter the topup amount "1000" lower than the topup limit and click Next
    Then The user see error message about topup tranlimit "Giá trị tối thiểu của giao dịch là 50,000VND và tối đa là 2,000,000VND!"

@Authenticated
  Scenario: The User enter the topup amount greater than the topup limit (Authenticated)
    Given The user choose topup by ViettinBank
    When The user enter the topup amount "2000001" greater than the topup limit and click Next
    Then The user see error message about topup tranlimit "Giá trị tối thiểu của giao dịch là 50,000VND và tối đa là 2,000,000VND!"
    
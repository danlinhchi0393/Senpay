Feature: topup by VTB 

  Background: 
    Given The user is staying login page
    When The user input valid phone number "0374441716" and pincode "123456" and The user click Login button
    When Get account balance before make transactions
@Unauthenticated @Authenticated
  Scenario: The User input invalid topup OTP timeout
    Given The user choose topup by ViettinBank
    When The user input valid topup "100000"
    When Input topup OTP timeout and click Agree button
    Then The user see error message finish topup transaction "Nhập sai OTP, vui lòng thực hiện lại giao dịch." 
    And Status of topup transaction is "Lỗi ngân hàng"
    And Account balance not change
@Unauthenticated @Authenticated
  Scenario: The User input invalid topup OTP
    Given The user choose topup by ViettinBank
    When The user input valid topup "100000"
    And Input invalid topup OTP and click Agree button
    Then The user see error message finish topup transaction "Nhập sai OTP, vui lòng thực hiện lại giao dịch."
  	 Then Status of topup transaction is "Lỗi ngân hàng"
    Then Account balance not change

@Unauthenticated @Authenticated
  Scenario: The User should topup successful by ViettinBank
    Given The user choose topup by ViettinBank
    When The user input valid topup "100000"
    And Input valid topup OTP and click Agree button
    Then Balance of wallet increase
    Then Status of topup transaction is "Hoàn thành"

  Scenario: The User enter the topup amount greater than the topup limit/day (Authenticated)
    Given The user choose topup by ViettinBank
    When The user enter the topup amount "10000000" greater than the topup limit and click Next
      Then The user see error message finish topup transaction "Số tiền giao dich tối đa bằng thẻ liên kết trong ngày la 30000000 VND"
  	 Then Status of topup transaction is "Giao dịch thất bại"
     Then Account balance not change
 
  Scenario: The User enter the topup amount greater than the topup limit/day (Unauthenticated)
    Given The user choose topup by ViettinBank
    When The user enter the topup amount "1000000" greater than the topup limit and click Next
      Then The user see error message finish topup transaction "Số tiền giao dich tối đa bằng thẻ liên kết trong ngày la 2000000 VND"
  	 Then Status of topup transaction is "Giao dịch thất bại"
     Then Account balance not change
    @Unauthenticated @Authenticated
Scenario: The User has bank account not enought balance
Given The user choose topup by ViettinBank
    When The user input valid topup "400000"
    And Input valid topup OTP and click Agree button
    Then The user see error message finish topup transaction "Giao dịch thất bại. Tài khoản trích nợ  không đủ số dư. Vui lòng phản hồi tới hotro@senpay.vn để được trợ giúp"
  	 Then Status of topup transaction is "Giao dịch thất bại"
    Then Account balance not change
    @Unauthenticated
  Scenario: The User enter the topup amount lower than the topup limit (Unauthenticated)
    Given The user choose topup by ViettinBank
    When The user enter the topup amount "1000" lower than the topup limit and click Next
    Then The user see error message about topup tranlimit "Giá trị tối thiểu của giao dịch là 10,000VND và tối đa là 2,000,000VND!"

  @Unauthenticated
  Scenario: The User enter the topup amount greater than the topup limit (Unauthenticated)
    Given The user choose topup by ViettinBank
    When The user enter the topup amount "2000001" greater than the topup limit and click Next
    Then The user see error message about topup tranlimit "Giá trị tối thiểu của giao dịch là 10,000VND và tối đa là 2,000,000VND!"
@Authenticated
    Scenario: The User enter the topup amount lower than the topup limit (Authenticated)
    Given The user choose topup by ViettinBank
    When The user enter the topup amount "1000" lower than the topup limit and click Next
    Then The user see error message about topup tranlimit "Giá trị tối thiểu của giao dịch là 10,000VND và tối đa là 10,000,000VND!"

@Authenticated
  Scenario: The User enter the topup amount greater than the topup limit (Authenticated)
    Given The user choose topup by ViettinBank
    When The user enter the topup amount "10000001" greater than the topup limit and click Next
    Then The user see error message about topup tranlimit "Giá trị tối thiểu của giao dịch là 10,000VND và tối đa là 10,000,000VND!"
    
   
    
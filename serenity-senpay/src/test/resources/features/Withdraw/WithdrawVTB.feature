Feature: withdraw by BIDV

  Background: 
    Given The user is staying login page
    When The user input valid phone number "0383584138" and pincode "123456" and The user click Login button
    When Get account balance before make transactions
 
  Scenario: The User input invalid withdraw OTP timeout
    Given The user choose withdraw by ViettinBank
    When Input invalid withdraw OTP timeout and click Agree button
    Then The user see error message finish transaction "Quá thời gian xác thực OTP" 
    And Status transaction is "Thất bại"
    And Account balance not change
  Scenario: The User input invalid withdraw OTP for the first time
    Given The user choose withdraw by ViettinBank
    When The user input valid withdraw amount
    And Input invalid withdraw OTP and click Agree button
    Then The user see error message "Nhập sai OTP. Số lần còn lại là: 2 lần"
  	 
   Scenario: The User input invalid withdraw OTP for the second time
    Given The user choose withdraw by ViettinBank
    When The user input valid withdraw amount
    And Input invalid withdraw OTP and click Agree button
    And Input invalid withdraw OTP and click Agree button
     Then The user see error message "Nhập sai OTP. Số lần còn lại là: 1 lần"
   Scenario: The User input invalid withdraw OTP for the third time
    Given The user choose withdraw by ViettinBank
    When The user input valid withdraw amount
    And Input invalid withdraw OTP and click Agree button
    And Input invalid withdraw OTP and click Agree button
    And Input invalid withdraw OTP and click Agree button
   Then The user see error message finish transaction "Nhập sai OTP quá số lần xác thực. Vui lòng thực hiện lại"
   Then Status transaction is "Thất bại"
    Then Account balance not change

  Scenario: The User should withdraw successful by ViettinBank
    Given The user choose withdraw by ViettinBank
    When The user input valid withdraw amount
    And Input valid withdraw OTP and click Agree button
    Then Balance of wallet decrease
    Then Status transaction is "Hoàn thành"
    Then Account balance decrease
   @Authenticated
  Scenario: The User enter the withdraw amount lower than the withdraw limit (Authenticated)
    Given The user choose withdraw by ViettinBank
    When The user enter the withdraw amount lower than the withdraw limit and click Next
    Then The user see error message about withdraw tranlimit "Giá trị tối thiểu của giao dịch là 100,000 VND và tối đa là 10,000,000 VND!"

@Authenticated
  Scenario: The User enter the withdraw amount greater than the withdraw limit (Authenticated)
    Given The user choose withdraw by ViettinBank
     When The user enter the withdraw amount "xxxx" greater than the withdraw limit and click Next
  Then The user see error message about withdraw tranlimit "Giá trị tối thiểu của giao dịch là 100,000 VND và tối đa là 10,000,000 VND!"
@Unauthenticated
 Scenario: The User enter the withdraw amount lower than the withdraw limit (Unauthenticated)
    Given The user choose withdraw by ViettinBank
    When The user enter the withdraw amount lower than the withdraw limit and click Next
    Then The user see error message about withdraw tranlimit "Giá trị tối thiểu của giao dịch là 100,000 VND và tối đa là 500,000 VND!"

@Unauthenticated
  Scenario: The User enter the withdraw amount greater than the withdraw limit (@Authenticated@Authenticated)
    Given The user choose withdraw by ViettinBank
    When The user enter the withdraw amount "500001" greater than the withdraw limit and click Next
    Then The user see error message about withdraw tranlimit "Giá trị tối thiểu của giao dịch là 100,000 VND và tối đa là 500,000 VND!"
  
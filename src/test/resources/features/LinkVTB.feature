Feature: Link Senpay wallet with Viettinbank
Background: 
    Given The user is staying login page
    When The user input valid phone number "0374441716" and pincode "123456" and The user click Login button
    When Get account balance before make transactions
      @test
   Scenario: The user link Senpay wallet with Viettinbank case input invalid OTP the first time
   Given User choose link Senpay wallet with Viettinbank
    When User enter information of card with card number 9704151531339480 cmnd 091709108 and click Agree button
  When Input invalid OTP from Viettinbank
   Then User see message Sai OTP. Vui lòng thực hiện lại giao dịch.
Scenario: The user link Senpay wallet with Viettinbank successful
   Given User choose link Senpay wallet with Viettinbank
   When User enter information of card with card number 9704151531339480 cmnd 091709108 and click Agree button
   When Input valid OTP from Viettinbank
   Then User see Bank_Viettinbank on Listbank screen and so the "****9480"
   Then Status of link is "Đã xác thực"

   Scenario: The user link Senpay wallet in case Senpay wallet have link bank before
   Given User choose link Senpay wallet with Viettinbank
    When User enter information of card with card number 9704151531339480 cmnd 091709108 and click Agree button
   Then User see notify about link duplicate "Bạn đã có tài khoản liên kết tại ATM Vietinbank, vui lòng xóa trước khi thêm mới hoặc chọn thêm tài khoản ngân hàng!"

   Scenario Outline: The user input invalid Viettinbank card number: <case>
   Given User choose link Senpay wallet with Viettinbank
  When User enter information of card with card number <so_the> cmnd <CMND> and click Agree button
   Then User see message <message>
   Examples: 
   |case|so_the|CMND|message|
   |Card number not match with Senpay account|9704151400015588|091709108|Thông tin liên kết không trùng khớp với thông tin đăng ký tại Vietinbank. Bạn vui lòng kiểm tra lại!|
   |Card number not exists|9704230080638334|091709108|Thông tin liên kết không trùng khớp với thông tin đăng ký tại Vietinbank. Bạn vui lòng kiểm tra lại!|

   Scenario: The user input invalid Viettinbank card: wrong month/year
   Given User choose link Senpay wallet with Viettinbank
   When User enter invalid information of card with card number "9704151531339480" cmnd "091709108" and click Agree button
   Then User see notify about link duplicate "Bạn đã có tài khoản liên kết tại ATM Vietinbank, vui lòng xóa trước khi thêm mới hoặc chọn thêm tài khoản ngân hàng!"

 
   
      
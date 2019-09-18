Feature: topup by napas

  Background: 
    Given The user is staying login page
    When The user input valid phone number "0374441716" and pincode "123456" and The user click Login button
 @tpbank  
   Scenario: Redirect from TPbank internetbanking successfully
   Given Choose topup from TPbank
   When Input amount information card "10000", "nguyen dan linh chi" and "9704230080638334"
   Then Redirect from internerbanking,see the title "TPBank eBanking"
   
   @viettin
   Scenario: Redirect from Viettin bank internetbanking successfully
   Given Choose topup from Viettinbank
   When Input amount information card "10000", "nguyen dan linh chi","9704230080638334" and valid from date
   Then Redirect from internerbanking,see the title "VietinBank e-Payment"
   
   @napas
   Scenario: Redirect from Napas gateway successfully
   Given Choose topup from BIDV
   When Input amount information card "10000" and click Agree button
   Then Redirect from internerbanking,see the title "Cổng thanh toán NAPAS"
   
  
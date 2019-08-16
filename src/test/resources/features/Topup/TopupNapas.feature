Feature: topup by TPbank

  Background: 
    Given The user is staying login page
    When The user input valid phone number "0374441716" and pincode "123456" and The user click Login button
 @tpbank  
   Scenario: Redirect from TPbank internerbanking successfully
   Given Choose topup from TPbank
   When Input amount information card "10000", "nguyen dan linh chi" and "9704230080638334"
   Then Redirect from internerbanking,see the title "TPBank eBanking"
   
  
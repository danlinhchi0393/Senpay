Feature: Link Senpay wallet with Viettinbank

  Scenario Outline: The user link Senpay wallet with Viettinbank successful
   Given User choose link Senpay wallet with Viettinbank
   When User enter <so_the>, <thang_phat_hanh>, <nam_phat_hanh>, <CMND> and click Agree button
   When Input valid OTP from Viettinbank
   Then User see Viettinbank on Listbank screen
   Then Status of link is "Đã xác thực"
   Examples: 
    |so_the|thang_phat_hanh|nam_phat_hanh|CMND|
    |9704151400015559|11|17|987654321|
   
    Scenario: The user link Senpay wallet with Viettinbank unsuccessful
   Given User choose link Senpay wallet with Viettinbank
   When User enter valid information about Viettinbank card and click Link button
   When Input invalid OTP from Viettinbank
   Then User see message "xxx"
   
    Scenario Outline: The user input invalid information about Viettinbank card case: <case>
   Given User choose link Senpay wallet with Viettinbank
   When User enter <so_the>, <thang_phat_hanh>, <nam_phat_hanh>, <CMND> and click Agree button

   Then User see message about card "<message>"
   Examples: 
    |case|so_the|thang_phat_hanh|nam_phat_hanh|CMND|message|
    |số thẻ không tồn tại|111|1|1|1| số thẻ không đúng|
   
   
   
Feature: Login
   Scenario: The User should see the homepage after login successful
    Given The user is staying login page
   When The user input valid phone number "0383584138" and pincode "123456" and The user click Login button
    Then  The user should see homepage
	
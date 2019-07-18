Feature: Login
   Scenario Outline: The User should see the homepage after login successful
    Given The user is staying login page
    When The user input valid <phone number> and <pincode> and The user click Login button
    Then  The user should see homepage
	Examples: 
		| phone number | pincode |
		| 0383584138   | 123456  | 
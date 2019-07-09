package Senpay.steps;

import net.thucydides.core.annotations.Steps;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.junit.Assert;

import Senpay.steps.serenity.UserLoginSteps;

public class LoginSteps {
	@Steps
	UserLoginSteps userlogin;
	
	 @Given("^The user is staying login page$")
	    public void the_user_is_staying_login_page() throws Throwable {
	        userlogin.OpenBrowser();
	    }

	    @When("^The user input valid phone number and pincode and The user click Login button$")
	    public void the_user_input_valid_phone_number_and_pincode_and_the_user_click_login_button() throws Throwable {
	      userlogin.LoginSuccess("0374441716","123456");
	    }

	    @Then("^ The user should see homepage$")
	    public void the_user_should_see_homepage() throws Throwable {
	    	String Username = userlogin.GetNameAccount();
			Assert.assertEquals("Nguyen Dan Linh Chi", Username);
	    }
}
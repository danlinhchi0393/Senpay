package com.senpay.serenity_cucumber.steps;

import net.thucydides.core.annotations.Steps;

import org.junit.Assert;

import com.senpay.serenity_cucumber.steps.serenity.LoginSteps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DefLoginSteps {

    @Steps
    LoginSteps login;
    
    @Given("^The user is staying login page$")
    public void the_user_is_staying_login_page() throws Throwable {
      login.is_the_login_page();
    }

    @When("^The user input valid phone number and pincode and The user click Login button$")
    public void the_user_input_valid_phone_number_and_pincode_and_the_user_click_login_button() throws Throwable {
        login.login_with("0383584138", "123456");
    }

    @Then("^ The user should see homepage$")
    public void the_user_should_see_homepage() throws Throwable {
    	String Username = login.get_name_account();
		Assert.assertEquals("Nguyen Dan Linh Chi", Username);
    }

}

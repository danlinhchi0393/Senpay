package com.senpay.serenity_cucumber.steps;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.senpay.serenity_cucumber.steps.serenity.LoginSteps;

import Common.GetOTP;
import Common.ReadExcel;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DefLoginSteps extends PageSteps {
	@Managed
	   WebDriver driver;
	@Steps
	LoginSteps login;

	@Given("^The user is staying login page$")
	public void the_user_is_staying_login_page() throws Throwable {
		login.is_the_login_page();
	}

	@When("^The user input valid phone number \"([^\"]*)\" and pincode \"([^\"]*)\" and The user click Login button$")
    public void the_user_input_valid_phone_number_something_and_pincode_something_and_the_user_click_login_button(String phone, String pincode) throws Throwable {
			login.login_with(phone,pincode);
		
	}

	@Then("^The user should see homepage$")
	public void the_user_should_see_homepage() throws Exception {
		String Username = login.get_name_account();
		Assert.assertEquals("Nguyen Dan Linh Chi", Username);
	}

}

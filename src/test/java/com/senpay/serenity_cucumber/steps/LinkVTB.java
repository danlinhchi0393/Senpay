package com.senpay.serenity_cucumber.steps;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.senpay.serenity_cucumber.steps.serenity.LoginSteps;

import Common.GetOTP;
import Common.ReadExcel;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LinkVTB {
	
	
	@Given("^User choose link Senpay wallet with Viettinbank$")
	public void user_choose_link_Senpay_wallet_with_Viettinbank() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^User enter (\\d+), (\\d+), (\\d+), (\\d+) and click Agree button$")
	public void user_enter_and_click_Agree_button(int arg1, int arg2, int arg3, int arg4) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^Input valid OTP from Viettinbank$")
	public void input_valid_OTP_from_Viettinbank() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^User see Viettinbank on Listbank screen$")
	public void user_see_Viettinbank_on_Listbank_screen() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^Status of link is \"([^\"]*)\"$")
	public void status_of_link_is(String arg1) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^User enter valid information about Viettinbank card and click Link button$")
	public void user_enter_valid_information_about_Viettinbank_card_and_click_Link_button() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^Input invalid OTP from Viettinbank$")
	public void input_invalid_OTP_from_Viettinbank() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^User see message \"([^\"]*)\"$")
	public void user_see_message(String arg1) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^User see message about card \"([^\"]*)\"$")
	public void user_see_message_about_card(String arg1) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
	

}

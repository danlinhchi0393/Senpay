package com.senpay.serenity_cucumber.steps;

import net.thucydides.core.annotations.Steps;

import org.junit.Assert;

import com.senpay.serenity_cucumber.LoginTestSuite;
import com.senpay.serenity_cucumber.pages.HomePage;
import com.senpay.serenity_cucumber.steps.serenity.HomeSteps;
import com.senpay.serenity_cucumber.steps.serenity.LoginSteps;


import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DefTopupSteps {

    @Steps
    LoginSteps login;
    HomeSteps home;
    @Given("^The user choose topup by visa$")
    public void the_user_choose_topup_by_visa() throws Throwable {
    	login.is_the_login_page();
    	login.login_with("0374441716", "123456");
    	home.choose_topup();
    }

    @When("^The user input valid card information $")
    public void the_user_input_valid_card_information() throws Throwable {
    	Thread.sleep(20000);
    	}

    @Then("^Balance of wallet increases and Transaction has status successful$")
    public void balance_of_wallet_increases_and_transaction_has_status_successful() throws Throwable {
        throw new PendingException();
    }

    @And("^Input OTP on cybersource$")
    public void input_otp_on_cybersource() throws Throwable {
        throw new PendingException();
    }

    @And("^click Agree button$")
    public void click_agree_button() throws Throwable {
        throw new PendingException();
    }


}

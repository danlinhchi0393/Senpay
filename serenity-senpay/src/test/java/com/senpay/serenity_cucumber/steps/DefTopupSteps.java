package com.senpay.serenity_cucumber.steps;

import net.thucydides.core.annotations.Steps;

import org.junit.Assert;

import com.senpay.serenity_cucumber.LoginTestSuite;
import com.senpay.serenity_cucumber.pages.HomePage;
import com.senpay.serenity_cucumber.steps.serenity.HomeSteps;
import com.senpay.serenity_cucumber.steps.serenity.LoginSteps;
import com.senpay.serenity_cucumber.steps.serenity.TopupSteps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import Common.*;
public class DefTopupSteps {
    @Steps
    LoginSteps login;
    @Steps
    HomeSteps home;
    @Steps
    TopupSteps topup;

    @Given("^The user choose topup by BIDV$")
    public void the_user_choose_topup_by_bidv() throws Throwable {
    	 String platform =  System.getProperty("testEnvironment");
    	 String OTP = GetOTP.GetOTP_From_Senpay();
         System.out.print(OTP);
    	login.is_the_login_page();
    	login.login_with("0383584138", "123456");
    	home.choose_topup();
    	//topup.choose_topup_by_link_BIDV("100000");
    }

    @When("^The user input valid topup amount $")
    public void the_user_input_valid_topup_amount() throws Throwable {
        topup.choose_topup_by_link_BIDV("100000");
    }
    @And("^Input OTP and click Agree button $")
    public void input_otp_and_click_agree_button() throws Throwable {
       String OTP = GetOTP.GetOTP_From_BIDV();
       System.out.print(OTP);
    }
    @Then("^Balance of wallet increases and Transaction has status successful$")
    public void balance_of_wallet_increases_and_transaction_has_status_successful() throws Throwable {
        throw new PendingException();
    }

    


}

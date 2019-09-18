package com.senpay.serenity_cucumber.steps;

import net.thucydides.core.annotations.Steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.senpay.serenity_cucumber.LoginTestSuite;
import com.senpay.serenity_cucumber.pages.HomePage;
import com.senpay.serenity_cucumber.steps.serenity.AccountInforSteps;
import com.senpay.serenity_cucumber.steps.serenity.HomeSteps;
import com.senpay.serenity_cucumber.steps.serenity.LoginSteps;
import com.senpay.serenity_cucumber.steps.serenity.TopupSteps;
import com.senpay.serenity_cucumber.steps.serenity.TransactionHistorySteps;

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
	@Steps
	AccountInforSteps account_infor;
	@Steps
	TransactionHistorySteps transaction_history;

	int total_balance_old = DefWithdrawVTBSteps.total_balance_old;

	@Given("^The user choose topup by ViettinBank$")
	public void the_user_choose_topup_by_viettinbank() throws Throwable {
		home.choose_topup();
		topup.choose_topup_by_link_VTB();
	}

	@Given("^The user choose topup by agribank$")
	public void the_user_choose_topup_by_agribank() throws Throwable {
		home.choose_topup();
		topup.choose_topup_by_link_agribank();
	}

	@When("^The user input invalid topup -(\\d+)$")
	public void the_user_input_invalid_topup(String amount) throws Exception {
		topup.choose_topup_by_link_with(amount);
	}

	@When("^Input topup OTP timeout and click Agree button$")
	public void input_invalid_topup_otp_timeout_and_click_agree_button() throws Throwable {
		Thread.sleep(180001);
		topup.choose_submit_topup_by_link_BIDV_with("123456");
	}

	@When("^Input valid topup OTP and click Agree button$")
	public void input_valid_topup_otp_and_click_agree_button() throws Throwable {
		String OTP = GetOTP.GetOTP_From_Viettinbank_link();
		System.out.print(OTP);
		topup.choose_submit_topup_by_link_BIDV_with(OTP);
	 //topup.choose_submit_topup_by_link_BIDV_with("123456");
	}

	@When("^Input invalid topup OTP and click Agree button$")
	public void input_invalid_topup_otp_and_click_agree_button() throws Throwable {
		topup.choose_submit_topup_by_link_BIDV_with("12345");
	}

	@When("^The user input valid topup \"([^\"]*)\"$")
	public void the_user_input_valid_topup_something(String amount) throws Throwable {
		topup.choose_topup_by_link_with(amount);
	}
	
	@When("^The user enter the topup amount \"([^\"]*)\" lower than the topup limit and click Next$")
	public void the_user_enter_the_topup_amount_something_lower_than_the_topup_limit_and_click_next(String amount)
			throws Throwable {
		topup.choose_topup_by_link_with(amount);
	}

	@When("^The user enter the topup amount \"([^\"]*)\" greater than the topup limit and click Next$")
	public void the_user_enter_the_topup_amount_something_greater_than_the_topup_limit_and_click_next(String amount)
			throws Throwable {
		topup.choose_topup_by_link_with(amount);
	}

	@Then("^The user see error message finish topup transaction \"([^\"]*)\"$")
	public void the_user_see_error_message_finish_topup_transaction(String expected) throws Throwable {
		String actual = topup.get_message_invalid_transaction();
		Assert.assertEquals(expected, actual);
	}

	@Then("^The user see error OTP message \"([^\"]*)\"$")
	public void the_user_see_error_otp_message_something(String expected) throws Throwable {
		String actual = topup.get_message_input_invalid_OTP();
		Assert.assertEquals(expected, actual);
	}

	@Then("^Status of topup transaction is \"([^\"]*)\"$")
	public void status_of_topup_transaction_is_something(String expected) throws Throwable {
		transaction_history.choose_topup_history();
		String actual = transaction_history.get_status_transaction();
		Assert.assertEquals(expected, actual);
	}

	@Then("^Balance of wallet increase$")
	public void balance_of_wallet_increase() throws Throwable {
		int total_balance_new = account_infor.get_main_total_balance();
		
		System.out.println("total_balance_new=" + total_balance_new);
		
		System.out.println("total_balance_old before plus=" + total_balance_old);
		
		total_balance_old = total_balance_old + 100000;
		
		System.out.println("total_balance_old after plus=" + total_balance_old);
		
		Assert.assertEquals(total_balance_old, total_balance_new);
	}

	@Then("^The user see error message about topup tranlimit \"([^\"]*)\"$")
	public void the_user_see_error_message_about_topup_tranlimit_something(String expected) throws Throwable {
		String actual = topup.get_message_validate_limit();
		Assert.assertEquals(expected, actual);
	}

//Topup by Napas
	@Given("^Choose topup from TPbank$")
	public void choose_topup_from_tpbank() throws Throwable {
		home.choose_topup();
		topup.choose_topup_by_tpbank();
	}
	 @Given("^Choose topup from Viettinbank$")
	    public void choose_topup_from_viettinbank() throws Throwable {
		 home.choose_topup();
			topup.choose_topup_by_vtbank();
	    }
	 @Given("^Choose topup from BIDV$")
	    public void choose_topup_from_bidv() throws Throwable {
		 home.choose_topup();
			topup.choose_topup_by_BIDVdometic();
	    }

	    @When("^Input amount information card \"([^\"]*)\" and click Agree button$")
	    public void input_amount_information_card_something_and_click_agree_button(String amount) throws Throwable {
	        topup.choose_topup_by_napas_with(amount);
	    }
	@When("^Input amount information card \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\"$")
	public void input_amount_information_card_something_something_and_something(String amount, String name,
			String number) throws Throwable {
		topup.choose_topup_by_tpbank_with(amount, name, number);
	}
	@When("^Input amount information card \"([^\"]*)\", \"([^\"]*)\",\"([^\"]*)\" and valid from date$")
    public void input_amount_information_card_something_somethingsomething_and_valid_from_date(String amount, String name, String number) throws Throwable {
        topup.choose_topup_by_viettinbank_with(amount, name, number);
    }
	@Then("^Redirect from internerbanking,see the title \"([^\"]*)\"$")
	public void redirect_from_internerbanking_see_the_title(String expected) throws Exception {
		String actual = topup.get_title();
		Assert.assertEquals(expected, actual);
	}
}

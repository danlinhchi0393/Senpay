package com.senpay.serenity_cucumber.steps;

import net.thucydides.core.annotations.Steps;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.senpay.serenity_cucumber.LoginTestSuite;
import com.senpay.serenity_cucumber.pages.HomePage;
import com.senpay.serenity_cucumber.steps.serenity.AccountInforSteps;
import com.senpay.serenity_cucumber.steps.serenity.HomeSteps;
import com.senpay.serenity_cucumber.steps.serenity.LoginSteps;
import com.senpay.serenity_cucumber.steps.serenity.TopupSteps;
import com.senpay.serenity_cucumber.steps.serenity.TransactionHistorySteps;
import com.senpay.serenity_cucumber.steps.serenity.WithdrawSteps;

import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import Common.*;

public class DefWithdrawVTBSteps extends PageSteps {
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
	@Steps
	WithdrawSteps withdraw;
	int total_balance_old;

	@When("^Get account balance before make transactions$")
	public void get_account_balance_before_make_transactions() throws Throwable {
		total_balance_old = account_infor.get_main_total_balance();
		System.out.print(total_balance_old);
	}

	@Given("^The user choose withdraw by ViettinBank$")
	public void the_user_choose_withdraw_by_ViettinBank() throws Exception {
		withdraw.choose_withdraw_by_link_VTB();
	}

	@When("^The user input valid withdraw amount$")
	public void the_user_input_valid_withdraw_amount() throws Exception {
		withdraw.choose_withdraw_with("200000");
	}

	@Then("^The user see error message \"([^\"]*)\"$")
	public void the_user_see_error_message_something(String expect) throws Throwable {
		System.out.print(expect);
		Assert.assertEquals(expect, withdraw.get_message_about_OTP());
	}

	@When("^The user enter the withdraw amount lower than the withdraw limit and click Next$")
	public void the_user_enter_the_withdraw_amount_lower_than_the_withdraw_limit_and_click_Next() throws Exception {
		withdraw.choose_withdraw_with("99990");
	}

	@When("^The user enter the withdraw amount \"([^\"]*)\" greater than the withdraw limit and click Next$")
	public void the_user_enter_the_withdraw_amount_something_greater_than_the_withdraw_limit_and_click_next(
			String amount) throws Throwable {
		System.out.print(amount);
		withdraw.choose_withdraw_with(amount);
	}

	@When("^Input invalid withdraw OTP timeout and click Agree button$")
	public void input_invalid_withdraw_OTP_timeout_and_click_Agree_button() throws Exception {
		// String OTP = GetOTP.GetOTP_From_Senpay();
		// System.out.print(OTP);
		Thread.sleep(120001);
		withdraw.input_withdraw_OTP("11111");
	}

	@When("^Input invalid withdraw OTP and click Agree button$")
	public void input_invalid_withdraw_OTP_and_click_Agree_button() throws Exception {
		withdraw.input_withdraw_OTP("11111");
	}

	@When("^Input valid withdraw OTP and click Agree button$")
	public void input_valid_withdraw_OTP_and_click_Agree_button() throws Exception {
		String OTP = GetOTP.GetOTP_From_Senpay();
		System.out.print(OTP);
		withdraw.input_withdraw_OTP(OTP);
	}

	@Then("^The user see error message finish transaction \"([^\"]*)\"$")
	public void the_user_see_error_message_finish_transaction_something(String expect) throws Throwable {
		String actual = withdraw.get_message_about_finish_tran();
		Assert.assertEquals(expect, actual);
	}

	@Then("^The user see error message about withdraw tranlimit \"([^\"]*)\"$")
	public void the_user_see_error_message_about_withdraw_tranlimit(String expect) throws Exception {
		String actual = withdraw.get_message_about_limit();
		Assert.assertEquals(expect, actual);
	}

	@Then("^Status transaction is \"([^\"]*)\"$")
	public void status_transaction_is_something(String expect) throws Throwable {
		transaction_history.choose_withdraw_history();
		String actual = transaction_history.get_status_transaction();
		System.out.print(actual);
		Assert.assertEquals(expect, actual);
	}

	@Then("^Account balance not change$")
	public void account_balance_not_change() throws Throwable {
		int account_balance_new = account_infor.get_main_total_balance();
		Assert.assertEquals(total_balance_old, account_balance_new);
	}

	@Then("^Account balance decrease$")
	public void account_balance_decrease() throws Throwable {
		int total_balance_new = account_infor.get_main_total_balance();
		System.out.print(total_balance_new);
		Assert.assertEquals(total_balance_old - 100000, total_balance_new);
	}
}

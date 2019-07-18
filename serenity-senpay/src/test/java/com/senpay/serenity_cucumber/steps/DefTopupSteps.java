package com.senpay.serenity_cucumber.steps;

import net.thucydides.core.annotations.Steps;

import org.junit.Assert;

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
	
	int total_balance_old;
	int amount = 100000;
	@Given("^The user choose topup by BIDV$")
	public void the_user_choose_topup_by_BIDV() throws Exception {
		
		topup.add_tab();
		total_balance_old = account_infor.get_main_total_balance();
		System.out.print(total_balance_old);
		home.choose_topup();
	}

	@When("^The user input valid topup amount$")
	public void the_user_input_valid_topup_amount() throws Exception {
		topup.choose_topup_by_link_BIDV_with("100000");
	}

	@When("^Input invalid OTP and click Agree button$")
	public void input_invalid_OTP_and_click_Agree_button() throws Exception {
		topup.choose_submit_topup_by_link_BIDV_with("123456");
	}

	@Then("^The user see error message$")
	public void the_user_see_error_message() throws Exception {
		boolean result = topup.Check_message_input_invalid_OTP("OTP sai.\n" + "Bạn còn 2 lần nhập OTP");
		Assert.assertEquals(true, result);

	}
	// Nap tien thanh con

	@When("^Input valid OTP and click Agree button$")
	public void input_valid_OTP_and_click_Agree_button() throws Exception {
		String OTP = GetOTP.GetOTP_From_BIDV();
		System.out.print(OTP);
		topup.choose_submit_topup_by_link_BIDV_with(OTP);
	}

	@Then("^Balance of wallet increases and Transaction has status successful$")
	public void then_Balance_of_wallet_increases_and_Transaction_has_status_successful() throws Exception {
		boolean result = topup.Check_result_message("Bạn đã thực hiện nạp 100,000VND thành công vào tài khoản.");
		Assert.assertEquals(true, result);
		System.out.print("pass message");
		int total_balance_new = account_infor.get_main_total_balance();
		System.out.print(total_balance_new);
		Assert.assertEquals(total_balance_old+100000, total_balance_new);
		transaction_history.choose_topup_history();
		boolean status = transaction_history.Check_status_topup("Hoàn thành");
		Assert.assertEquals(true, status);
	}
}

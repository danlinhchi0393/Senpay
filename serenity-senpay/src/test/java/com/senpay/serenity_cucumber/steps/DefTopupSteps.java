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

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import Common.*;

public class DefTopupSteps extends PageSteps {
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
	//int amount = 10000;
	//boolean Authenticated = false;

	// nhap OTP sai 1 lan
	@Given("^The user choose topup by BIDV$")
	public void the_user_choose_topup_by_BIDV() throws Exception {
		// topup.add_tab();
		topup.takeSnapShot();
		total_balance_old = account_infor.get_main_total_balance();
		System.out.print(total_balance_old);
		home.choose_topup();
	}

	@When("^The user input valid topup amount$")
	public void the_user_input_valid_topup_amount() throws Exception {
		topup.choose_topup_by_link_BIDV_with("10000");
	}

	@When("^Input invalid OTP and click Agree button$")
	public void input_invalid_OTP_and_click_Agree_button() throws Exception {
		topup.choose_submit_topup_by_link_BIDV_with("123456");
	}

	@Then("^The user see error message for the first time$")
    public void the_user_see_error_message_for_the_first_time() throws Throwable {
		boolean result = topup.Check_message_input_invalid_OTP("OTP sai.\n" + "Bạn còn 2 lần nhập OTP");
		Assert.assertEquals(true, result);
		transaction_history.choose_topup_history();
		boolean status = transaction_history.Check_status_topup("Khởi tạo");
		Assert.assertEquals(true, status);

	}
	@Then("^The user see error message for the second time$")
    public void the_user_see_error_message_for_the_second_time() throws Throwable {
		topup.choose_submit_topup_by_link_BIDV_with("123456");
		boolean result = topup.Check_message_input_invalid_OTP("OTP sai.\n" + "Bạn còn 1 lần nhập OTP");
		Assert.assertEquals(true, result);
		transaction_history.choose_topup_history();
		boolean status = transaction_history.Check_status_topup("Khởi tạo");
		Assert.assertEquals(true, status);
    }

	
	// Nap tien thanh cong

	@When("^Input valid OTP and click Agree button$")
	public void input_valid_OTP_and_click_Agree_button() throws Exception {
		String OTP = GetOTP.GetOTP_From_BIDV();
		System.out.print(OTP);
		topup.choose_submit_topup_by_link_BIDV_with(OTP);
	}

	@Then("^Balance of wallet increases and Transaction has status successful$")
	public void then_Balance_of_wallet_increases_and_Transaction_has_status_successful() throws Exception {
		boolean result = topup.Check_result_message("Bạn đã thực hiện nạp 10,000VND thành công vào tài khoản.");
		Assert.assertEquals(true, result);
		System.out.print("pass message");
		int total_balance_new = account_infor.get_main_total_balance();
		System.out.print(total_balance_new);
		Assert.assertEquals(total_balance_old + 10000, total_balance_new);
		transaction_history.choose_topup_history();
		boolean status = transaction_history.Check_status_topup("Hoàn thành");
		Assert.assertEquals(true, status);
		String message_transaction_from_BIDV = GetOTP.Get_message_transaction_From_BIDV();
		Assert.assertEquals(message_transaction_from_BIDV, "-10,000VND");
	}

	@When("^The user enter the topup amount lower than the limit and click Next$")
	public void the_user_enter_the_topup_amount_lower_than_the_limit_and_click_Next() throws Exception {

		topup.choose_topup_by_link_BIDV_with("1000");
	}
	@When("^Input invalid OTP timeout and click Agree button$")
	 public void input_invalid_OTP_timeout_and_click_Agree_button() throws Exception {
		String OTP = GetOTP.GetOTP_From_BIDV();
		System.out.print(OTP);
		Thread.sleep(120001);
		topup.choose_submit_topup_by_link_BIDV_with(OTP);
	    }
	 
	     // Write code here that turns the phrase above into concrete actions
	 
	 @Then("^The user see error message topup unsuccessful$")
	    public void the_user_see_error_message_topup_unsuccessful() throws Throwable {
		 boolean result = topup.Check_message_finish_transaction("Giao dịch thất bại.");
			Assert.assertEquals(true, result);
			System.out.print("pass message");
			int total_balance_new = account_infor.get_main_total_balance();
			System.out.print(total_balance_new);
			Assert.assertEquals(total_balance_old, total_balance_new);
			transaction_history.choose_topup_history();
			boolean status = transaction_history.Check_status_topup("Giao dịch thất bại");
			Assert.assertEquals(true, status);
		}
	 @Then("^The user see error message block OTP$")
	    public void the_user_see_error_message_block_otp() throws Throwable {
		 boolean result = topup.Check_message_invalid_OTP_5times("Khóa OTP tạm thời do nhập sai OTP 5 lần liên tiếp. Vui lòng liên hệ ngân hàng để biết thêm thông tin.");
			Assert.assertEquals(true, result);
			System.out.print("pass message");
	    }   
	

	 
	@Then("^The user see error message about tranlimit$")
	public void the_user_see_error_message_about_tranlimit() throws Exception {
		List<String> messages = new ArrayList<String>();
		messages.add("Giá trị tối thiểu của giao dịch là 10,000VND và tối đa là 2,000,000VND!");
		messages.add("Giá trị tối thiểu của giao dịch là 10,000VND và tối đa là 10,000,000VND!");
		System.out.print(messages.get(0));
		if (this.Authenticated == false) {
			boolean result = topup.Check_message_validate_limit(messages.get(0));
			Assert.assertEquals(true, result);
		} else {
			boolean result = topup.Check_message_validate_limit(messages.get(1));
			Assert.assertEquals(true, result);
		}
	}

	@When("^The user enter the topup amount greater than the limit and click Next$")
	public void the_user_enter_the_topup_amount_greater_than_the_limit_and_click_Next() throws Exception {
		if (this.Authenticated == false) {
			topup.choose_topup_by_link_BIDV_with("3000000");
		} else
			topup.choose_topup_by_link_BIDV_with("11000000");
	}
}

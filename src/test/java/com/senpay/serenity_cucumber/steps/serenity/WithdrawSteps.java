package com.senpay.serenity_cucumber.steps.serenity;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.Is.is;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;

import com.senpay.serenity_cucumber.pages.HomePage;
import com.senpay.serenity_cucumber.pages.LoginPage;
import com.senpay.serenity_cucumber.pages.WithdrawPage;

import static org.hamcrest.Matchers.hasItem;

public class WithdrawSteps extends ScenarioSteps {

	WithdrawPage withdraw;
	HomePage homapage;
	@Step
	public void choose_withdraw_by_link_VTB() {
		homapage.chooseTransactions();
		homapage.chooseWithdraw();
		withdraw.choose_VTB_LK();
	}
	@Step
	public void choose_withdraw_with(String amount) {
		withdraw.input_amount_withdraw(amount);
		withdraw.choose_NextBtn();
	}
	@Step
	public void input_withdraw_OTP(String otp) {
		withdraw.input_OTP_withdraw(otp);
		withdraw.choose_AgreeBtn();
	}
	@Step
	public String get_message_about_OTP() {
		String message =withdraw.get_message_about_OTP();
		return message;
}
	@Step
	public String get_message_about_limit() {
		String message =withdraw.get_message_about_limit();
		return message;
}
	@Step
	public String get_message_about_sodu() {
		String message =withdraw.get_message_about_sodu();
		return message;
}
	@Step
	public String get_message_about_finish_tran() {
		String message =withdraw.get_message_about_finish_tran();
		return message;
}
}
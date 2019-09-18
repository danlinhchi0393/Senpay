package com.senpay.serenity_cucumber.pages;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import net.serenitybdd.core.pages.WebElementFacade;
import java.util.stream.Collectors;

import net.serenitybdd.core.annotations.findby.FindBy;

import net.thucydides.core.pages.PageObject;

import java.util.List;

//@DefaultUrl("https://senpay.vn/")
public class WithdrawPage extends PageObject {
	@FindBy(css = "#MainContent_ddlBank > option:nth-child(2)")
	WebElement VTB_LK;
	@FindBy(css = "input#MainContent_txtAmount")
	WebElement Amount_withdraw;
	@FindBy(css = "input#MainContent_btStep1")
	WebElement NextBtn;
	@FindBy(css = "input#MainContent_txtOTP")
	WebElement OTP_withdraw;
	@FindBy(css = "input#MainContent_btStep2")
	WebElement AgreeBtn;
	@FindBy(css = "#MainContent_messagebox2")
	WebElement message_about_OTP;
	@FindBy(css = "#MainContent_messagebox1")
	WebElement message_about_sodu;
	@FindBy(css = "#MainContent_cusCustom")
	WebElement message_about_limit;
	@FindBy(css = "#MainContent_ruttienstep4")
	WebElement message_about_finish_tran;
	
	
	public void choose_VTB_LK() {
		VTB_LK.click();
	}

	public void input_amount_withdraw(String amount) {
		Amount_withdraw.sendKeys(amount);
	}

	public void choose_NextBtn() {
		NextBtn.click();
	}
	public void input_OTP_withdraw(String otp) {
		OTP_withdraw.sendKeys(otp);
	}
	public void choose_AgreeBtn() {
		AgreeBtn.click();
	}
	public String get_message_about_OTP() {
		String message= message_about_OTP.getText();
		return message;
	}
	
	public String get_message_about_limit() {
		String message= message_about_limit.getText();
		return message;
	}
	public String get_message_about_sodu() {
		String message= message_about_sodu.getText();
		return message;
	}
	public String get_message_about_finish_tran() {
		String message= message_about_finish_tran.getText();
		return message;
	}
}
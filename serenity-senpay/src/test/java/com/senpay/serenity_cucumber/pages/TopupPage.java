
package com.senpay.serenity_cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.thucydides.core.pages.PageObject;

public class TopupPage extends PageObject  {

//Thẻ ATM nội địa
	@FindBy(css = "div#domestic")
	WebElement ATMDomestic;
	@FindBy(css = "input[bankname=vietcombank]")
	WebElement VCB;
	@FindBy(css = "input#txtAmount_Domestic")
	WebElement AmountTopupATM;
	@FindBy(css = "#MainContent_Default1_ctl01_btnAgree")
	WebElement AgreeTopup;
	@FindBy(css = "#gateway > table > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(6) > td:nth-child(3) > img")
	WebElement NapasCancel;
	@FindBy(css = "input#gateway_CardName")
	WebElement CardName;
	@FindBy(css = "input#gateway_CardNumber")
	WebElement CardNumber;
	@FindBy(css = "#CardMonth > option:nth-child(4)")
	WebElement CardMonth;
	@FindBy(css = "#CardYear > option:nth-child(9)")
	WebElement CardYear;
	@FindBy(css = "#gateway > table > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(6) > td:nth-child(4) > input[type=image]")
	WebElement NapasAgreeInforATM;
	@FindBy(css = "#verifyotp_OtpCode")
	WebElement OtpCode;

	// Thẻ visa/master
	@FindBy(css = "div#internal")
	WebElement DebitCard;
	@FindBy(css = "input[bankname = visa]")
	WebElement Visa;
	@FindBy(css = "input[bankname = mastercard]")
	WebElement Mastercard;
	@FindBy(css = "input#txtAmount_Internal")
	WebElement AmountTopupInternal;
	@FindBy(css = "#MainContent_Default1_ctl00_txtCardName")
	WebElement InternalCardName;
	@FindBy(css = "#MainContent_Default1_ctl00_txtCardNumber")
	WebElement InternalCardNumber;
	@FindBy(css = "#MainContent_Default1_ctl00_ddlMonthList")
	WebElement InternalCardMonth;
	@FindBy(css = "#MainContent_Default1_ctl00_ddlMonthList > option:nth-child(6)")
	WebElement InternalCardMonth06;
	@FindBy(css = "#MainContent_Default1_ctl00_ddlYearList")
	WebElement InternalCardYear;
	@FindBy(css = "#MainContent_Default1_ctl00_ddlYearList > option:nth-child(20)")
	WebElement InternalCardYear2020;
	@FindBy(css = "#MainContent_Default1_ctl00_txtCCV")
	WebElement InternalCCV;
	@FindBy(css = "#MainContent_Default1_ctl00_btnAgree")
	WebElement InternalAgree;
	@FindBy(css = "#password")
	WebElement CBSPassword;
	@FindBy(css = "input[type=submit]")
	WebElement CBSAgree;
//VietinBank	
	@FindBy(css = "input[bankname=vietinbank]")
	WebElement ViettinBank;
	@FindBy(css = "input#MainContent_Default1_ctl03_txtCardHolderName")
	WebElement ATMCardHolderNameVTB;

	@FindBy(css = "input#MainContent_Default1_ctl03_txtCardNumber")
	WebElement ATMCardNumberVTB;

	@FindBy(css = "#MainContent_Default1_ctl03_ddlMonthList")
	WebElement ATMMonthList;
	@FindBy(css = "#MainContent_Default1_ctl03_ddlMonthList > option:nth-child(4)")
	WebElement ATMMonthList04;
	
	@FindBy(css = "#MainContent_Default1_ctl03_ddlYearList")
	WebElement ATMYearList;
	@FindBy(css = "#MainContent_Default1_ctl03_ddlYearList > option:nth-child(20)")
	WebElement ATMYearList2019;
	@FindBy(css = "#MainContent_Default1_ctl03_btnAgree")
	WebElement AgreeViettinbank;
//Tpbank
	@FindBy(css = "input[bankname=tpbank]")
	WebElement TienPhongBank;
	
	@FindBy(css = "input#MainContent_Default1_ctl02_txtCardHolderName")
	WebElement ATMCardHolderNameTPB;

	@FindBy(css = "input#MainContent_Default1_ctl02_txtCardNumber")
	WebElement ATMCardNumberTPB;
	
	@FindBy(css = "#MainContent_Default1_ctl02_btnAgree")
	WebElement AgreeTPbankbank;
//Method
	public void chooseATMDomestic() {
		ATMDomestic.click();
	}

	public void chooseVCB() {
		VCB.click();
	}

	public void InputAmount(String amount) {
		AmountTopupATM.sendKeys(amount);
	}

	public void ChooseAgreeTopup() {
		AgreeTopup.click();
	}

	public void ChosseCancelTopup_Napas() {
		NapasCancel.click();
	}

	public void InputCardName(String cardname) {
		CardName.sendKeys(cardname);
	}

	public void InputCardNumber(String cardnumber) {
		CardNumber.sendKeys(cardnumber);
	}

	public void ChooseCardMonth() {
		CardMonth.click();
	}

	public void ChooseCardYear() {
		CardYear.click();
	}

	public void ChooseAgreeTopup_Napas() {
		NapasAgreeInforATM.click();
	}

//Visa/master
	public void ChooseDebitCard() {
		DebitCard.click();
	}

	public void ChooseVisa() {
		Visa.click();
	}

	public void ChooseMastercard() {
		Mastercard.click();
	}

	public void InputAmountTopupInternal(String amount) {
		AmountTopupInternal.sendKeys(amount);
	}

	public void InputInternalCardName(String cardnamne) {
		InternalCardName.sendKeys(cardnamne);
	}

	public void InputInternalCardNumber(String cardnumber) {
		InternalCardNumber.sendKeys(cardnumber);
	}

	public void ChooseInternalCardMonth() {
		InternalCardMonth.click();
	}

	public void ChooseInternalCardMonth06() {
		InternalCardMonth06.click();
	}

	public void ChooseInternalCardyear() {
		InternalCardYear.click();
	}

	public void ChooseInternalCardYear2020() {
		InternalCardYear2020.click();
	}

	public void InputInternalCCV(String CVV) {
		InternalCCV.sendKeys(CVV);
	}
	public void ChooseInternalAgree() {
		InternalAgree.click();
	}

	public void InputCBSPassword(String OTP) {
		CBSPassword.sendKeys(OTP);
	}

	public void ChooseCBSAgree() {
		CBSAgree.click();
	}

//Viettinbank
	public void ChooseViettinbank() {
		ViettinBank.click();
	}
	public void InputATMCardHolderNameVTB(String name) {
		ATMCardHolderNameVTB.sendKeys(name);
	}
	
	public void InputATMCardNumberVTB(String number) {
		ATMCardNumberVTB.sendKeys(number);
	}
	public void ChooseMonth04() {
		//ATMMonthList.click();
       ATMMonthList04.click();
	}
	public void ChooseAgreeViettinbank() {
		//ATMMonthList.click();
		AgreeViettinbank.click();
	}
//TPbank
	public void ChooseTPbank() {
		TienPhongBank.click();
	}
	public void InputATMCardHolderNameTPB(String name) {
		ATMCardHolderNameTPB.sendKeys(name);
	}
	
	public void InputATMCardNumberTPB(String number) {
		ATMCardNumberTPB.sendKeys(number);
	}
	
	public void ChooseAgreeTPbank() {
		//ATMMonthList.click();
		AgreeTPbankbank.click();
	}
	
//Ngân hang LK 
	@FindBy(css = "#link-img-bank-21 > img:nth-child(2)")
	WebElement link_BIDV ;
	@FindBy(css = "#link-img-bank-7 > img:nth-child(2)")
	WebElement link_Agribank ;
	
	@FindBy(css = "#link-img-bank-9 > img:nth-child(2)")
	WebElement link_VTB ;
	
	@FindBy(css = "input#txtAmount_CardLink")
	WebElement Amount_cardlink ;
	@FindBy(css = "input#MainContent_Default1_btnAgree")
	WebElement AgreeButton ;
	@FindBy(css = "input#txt_otp_new")
	WebElement OTP ;
	
	@FindBy(css ="input#MainContent_Default1_btnsubmitotp")
	WebElement submit_button ;
	
	@FindBy(css = "span#MainContent_Default1_lbl_err_new")
	WebElement error_OTP_message;
	@FindBy(css = "span#MainContent_Default1_lbresult")
	WebElement result_message;
	
	@FindBy(css = "span#MainContent_Default1_CustomValidatorddl")
	WebElement message_validate_limit;
	
	
	@FindBy(css = "#DivInfoAccount > div:nth-child(1)")
	WebElement message_finish_transaction;
	@FindBy(css = "#MainContent_Default1_message")
	WebElement message_invalid_transaction;

	public void Choose_link_BIDV() {
		link_BIDV.click();
	}
	public void Choose_link_VTB() {
		link_VTB.click();
	}
	public void Choose_link_Agribank() {
		link_Agribank.click();
	}
	public void InputAmount_BIDV(String amount) {
		Amount_cardlink.sendKeys(amount);
	}
	public void Choose_Agree_BIDV_button() {
		AgreeButton.click();
	}
	public void Input_OTP(String OTPvalue) {
		OTP.sendKeys(OTPvalue);
	}
	public void Choose_submit_bidv() {
		submit_button.click();
	}
	public String Get_error_OTP_message() {
		String error_message_value = error_OTP_message.getText();
		return error_message_value;
	}
	public String Get_result_message() {
		String result_message_value = result_message.getText();
		return result_message_value;
	}
	public String Get_message_validate_limit() {
		String message = message_validate_limit.getText();
		return message;
	}
	public String Get_message_finish_transaction() {
		String message = message_finish_transaction.getText();
		return message;
	}
	public String Get_message_invalid_transaction() {
		String message = message_invalid_transaction.getText();
		return message;
	}
}

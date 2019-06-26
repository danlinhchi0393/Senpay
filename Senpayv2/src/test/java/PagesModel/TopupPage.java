
package PagesModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopupPage {

	WebDriver driver;
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
	
	
}

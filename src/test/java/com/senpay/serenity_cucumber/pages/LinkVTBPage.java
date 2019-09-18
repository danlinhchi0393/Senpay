package com.senpay.serenity_cucumber.pages;

import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.support.FindAll;
import net.thucydides.core.pages.PageObject;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;

import net.serenitybdd.core.pages.WebElementFacade;
import java.util.stream.Collectors;

import javax.xml.xpath.XPath;

import net.serenitybdd.core.annotations.findby.FindBy;

import net.thucydides.core.pages.PageObject;

import java.util.List;

//@DefaultUrl("https://senpay.vn/")
public class LinkVTBPage extends PageObject {
	private static final String Keys = null;
	@FindBy(xpath = "//*[@id='MainContent_btnnew_acc']")
	WebElement add_bank_acc;
	@FindBy(css = "#MainContent_drbankname option[value=\"9\"]")
	WebElement ChooseLinkVTB;
	@FindBy(xpath = "//*[@id='MainContent_txtNumberCard']")
	WebElement NumberCard_vtb;
	@FindBy(css = "#MainContent_ddlIssueMonth > option:nth-child(12)")
	WebElement MonthCard_12_vtb;
	@FindBy(xpath = "//*[@id='MainContent_ddlIssueMonth']/option[@value='11']")
	WebElement MonthCard_11_vtb;
	@FindBy(xpath = "//*[@id='MainContent_ddlIssueMonth']/option[@value='04']")
	WebElement MonthCard_04_vtb;

	@FindBy(css = "#MainContent_ddlIssueYear > [value =\"17\"]")
	WebElement YearCard_17_vtb;
	@FindBy(css = "#MainContent_ddlIssueYear > [value =\"19\"]")
	WebElement YearCard_19_vtb;
	@FindBy(css = "input#MainContent_txtCMTCard")
	WebElement CMTCard;
	@FindBy(xpath = "//select[@class='validator textinputtk']")
	WebElement BankDropDown;

	public List<WebElement> bankList;
	@FindBy(xpath = "//select[@id='MainContent_drprovince']")
	WebElement cityDropDown;
	@FindBy(xpath = "//select[@id='MainContent_drprovince']/option[3]")
	WebElement city;
	@FindBy(css = "#MainContent_btOKCard")
	WebElement btnDongypopup;
	@FindBy(xpath = "//*[@id='MainContent_op2']")
	WebElement radio_button_ATM;
	@FindBy(xpath = "//*[@id='MainContent_txtCMTCard']")
	WebElement CMND;
	@FindBy(xpath = "//*[@id='MainContent_txtOTP']")
	WebElement OTP;
	@FindBy(xpath = "//*[@id='email']")
	WebElement email;
	@FindBy(xpath = "//*[@id='password']")
	WebElement pass;
	@FindBy(xpath = "//*[@id='signin_btn']")
	WebElement Button_login;

	@FindBy(xpath = "/html/body/div[2]/div/div/div[3]/div/nav/div[2]/div[1]/div/div[1]/div/div/div[1]/div[10]/a")
	WebElement Test_OTP;
	@FindBy(css = "div.c-message--last .c-message__body")
	WebElement lasT_message;
	@FindBy(xpath = "//*[@id='MainContent_lbstatus']")
	WebElement Incorrect_card_VTB;

	@FindBy(xpath = "//*[@id='MainContent_btStepOtp']")
	WebElement bnt_Tieptuc;

	@FindBy(xpath = "//*[@id='MainContent_txtOTP']")
	WebElement OTP_Lien_ket;
	@FindBy(xpath = "//*[@id='MainContent_right_content']/table/tbody/tr[1]/td[4]")
	WebElement Acc_number;

	@FindBy(xpath = "	//*[@id='MainContent_right_content']/table/tbody/tr[1]/td[7]")
	WebElement Status_onlist;
	@FindBy(css = "#MainContent_lblMessageVietin")
	WebElement message_link_duplicate;

	public void Choose_LinkVTB() {

	}

	public void Add_bank_acc() {
		add_bank_acc.click();

	}

	public void select_VTB_bank() {
		// System.out.println("Size: " + bankList.size());
		// BankDropDown.click();
		ChooseLinkVTB.click();

	}

	public void select_city() {
		// cityDropDown.click();
		// city.click();

	}

	public void select_ATM() {
		radio_button_ATM.isSelected();
		radio_button_ATM.click();
	}

	public void input_the_bank_number(String so_the) throws InterruptedException {

		NumberCard_vtb.sendKeys(so_the);
	}

	public void input_CMND(String cMND) {
		CMND.sendKeys(cMND);

	}

	public void clickOKbutton() {
		btnDongypopup.click();

	}

	public void Click_Next() {
		bnt_Tieptuc.click();
	}

	public void Input_OTP(String OTP) {
		OTP_Lien_ket.sendKeys(OTP);
	}

	public String get_message_incase_incorrect_card() {
		String result_message_value = Incorrect_card_VTB.getText();
		System.out.println(result_message_value);
		return result_message_value;

	}

	public String get_message_incase_incorrect_OTP() {
		String result_message_value = Incorrect_card_VTB.getText();
		System.out.println(result_message_value);
		return result_message_value;

	}

	public String get_Number_acc() {
		String result_number_acc = Acc_number.getText();
		return result_number_acc;

	}

	public String get_message_inList() {
		String status_actual = Status_onlist.getText();
		return status_actual;

	}
	public void add_month_12() {
		MonthCard_12_vtb.click();

	}
	public void add_month_11() {
		MonthCard_11_vtb.click();

	}

	public void add_year_17() {
		YearCard_17_vtb.click();

	}
	public void add_month_04() {
		MonthCard_04_vtb.click();

	}

	public void add_year_19() {
		YearCard_19_vtb.click();

	}
	public boolean check_cmnd_enabled() {
		if (CMND.isEnabled()==true) return true;
		else return false;

	}
	public String get_message_link_duplicate() {
		String status_actual = message_link_duplicate.getText();
		return status_actual;

	}
	
}
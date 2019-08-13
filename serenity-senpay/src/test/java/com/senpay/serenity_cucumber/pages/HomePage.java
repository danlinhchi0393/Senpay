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
public class HomePage extends PageObject {
	@FindBy(css = "a#MainMenu_hlTrans")
	WebElement TabTransaction;
	@FindBy(css = "a#MainMenu_hlAccount")
	WebElement TabAccount;
	@FindBy(css = "a.gdnt")
	WebElement MenuTopup;
	@FindBy(css = "a.tttk")
	WebElement MenuInfor_account;
	
	@FindBy(css = "a.gdrt")
	WebElement MenuWithdraw;
	public void chooseTransactions() {
		TabTransaction.click();
	}

	public void chooseAccount() {
		TabAccount.click();
	}

	public void chooseTopup() {
		MenuTopup.click();
	}
	public void chooseInfor_account() {
		MenuInfor_account.click();
	}
	public void chooseWithdraw() {
		MenuWithdraw.click();
	}
}
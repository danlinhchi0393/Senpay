
package com.senpay.serenity_cucumber.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.thucydides.core.pages.PageObject;
public class HistoryTransactionPage  extends PageObject {


	@FindBy(css = "select#MainContent_ddlTypeTransaction")
	WebElement TypeTransaction;
	@FindBy(css = "#MainContent_ddlTypeTransaction > option:nth-child(9)")
	WebElement TopupTransaction;
	@FindBy(css ="#MainContent_btSearch")
	WebElement SearchBtn;
	@FindBy(css ="#tablelist > tbody > tr:nth-child(1) > td:nth-child(7)")
	WebElement Status;

	public void ChooseTypeTransaction() {
		TypeTransaction.click();
	}

	public void ChooseTopupTransaction() {
		TopupTransaction.click();
	}

	public void ChooseSearch() {
		SearchBtn.click();
	}
	public String GetStatusTransaction() {
		String StatusTransaction = Status.getText();
		return StatusTransaction;
	}
}

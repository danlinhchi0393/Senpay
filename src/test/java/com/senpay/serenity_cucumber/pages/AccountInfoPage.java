
package com.senpay.serenity_cucumber.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.thucydides.core.pages.PageObject;

public class AccountInfoPage  extends PageObject {

	@FindBy (css = "#MainContent_lblAmount")
	WebElement MainAmount;
	
	@FindBy (css ="#DivInfoAccount > div:nth-child(1)")
	WebElement MessageInfo;
	
	
	public int CheckWallet() {
		String walletText = MainAmount.getText();
		String walletText1 = walletText.replace(",", "");
		int wallet = Integer.parseInt(walletText1);
		return wallet;
	}
	public String CheckWallet_original() {
		String walletText = MainAmount.getText();
		return walletText;
	}
	
}


package Senpay.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
@DefaultUrl("https://senpay.vn/")

public class HomePage extends PageObject {
	@FindBy(css = "a#MainMenu_hlTrans")
	WebElement TabTransaction;
	@FindBy(css = "a#MainMenu_hlAccount")
	WebElement TabAccount;
	@FindBy(css = "a.gdnt")
	WebElement MenuTopup;


	public void chooseTransactions() {
		TabTransaction.click();
	}

	public void chooseAccount() {
		TabAccount.click();
	}

	public void chooseTopup() {
		MenuTopup.click();
	}
}

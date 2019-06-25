
package PagesModel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class HomePage {

	WebDriver driver;

	@FindBy(css = "a#MainMenu_hlTrans")
	WebElement TabTransaction;
	@FindBy(css = "a#MainMenu_hlAccount")
	WebElement TabAccount;
	@FindBy(css = "a.gdnt")
	WebElement MenuTopup;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

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

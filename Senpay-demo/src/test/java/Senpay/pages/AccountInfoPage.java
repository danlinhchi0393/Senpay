
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

public class AccountInfoPage extends PageObject {


	@FindBy (css = "#MainContent_lblAmount")
	WebElement MainAmount;
	
	@FindBy (css ="#DivInfoAccount > div:nth-child(1)")
	WebElement MessageInfo;
	
	
	
	public int CheckWallet() {
		String walletText = MainAmount.getText();
		String walletText1 = walletText.replace(",", "");
		int wallet = Integer.parseInt(walletText1);
		System.out.print(wallet);
		return wallet;
	}
	
}

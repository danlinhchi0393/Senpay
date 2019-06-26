
package PagesModel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import base.InstanciateDriver;
public class AccountInfoPage {

	WebDriver driver;
	@FindBy (css = "#MainContent_lblAmount")
	WebElement MainAmount;
	
	@FindBy (css ="#DivInfoAccount > div:nth-child(1)")
	WebElement MessageInfo;
	
	
	
	public AccountInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public int CheckWallet() {
		String walletText = MainAmount.getText();
		String walletText1 = walletText.replace(",", "");
		int wallet = Integer.parseInt(walletText1);
		System.out.print(wallet);
		return wallet;
	}
	
}

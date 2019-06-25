
package PagesModel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class ReuseFuntion {

	WebDriver driver;
	TopupPage topup = PageFactory.initElements(driver, TopupPage.class);
	HomePage homepage = PageFactory.initElements(driver, HomePage.class);
	AccountInfoPage accountInfo = PageFactory.initElements(driver, AccountInfoPage.class);
	LoginPage login = PageFactory.initElements(driver, LoginPage.class);
	HistoryTransactionPage historytransaction = PageFactory.initElements(driver, HistoryTransactionPage.class);
	

	public ReuseFuntion(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		public void LoginSuccess(String phone, String pin) {
			driver.findElement(By.cssSelector("a#btnLogin")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			LoginPage login = PageFactory.initElements(driver, LoginPage.class);
			login.txtPhone.sendKeys(phone);
			login.btnNext.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			login.txtPincode.sendKeys(pin);
		}
	
	public String GetStatusTransaction() {
		HomePage homepage = PageFactory.initElements(driver, HomePage.class);
		HistoryTransactionPage historytransaction = PageFactory.initElements(driver, HistoryTransactionPage.class);
		homepage.chooseTransactions();
		historytransaction.ChooseTypeTransaction();
		historytransaction.ChooseTopupTransaction();
		historytransaction.ChooseSearch();
		String StatusTransaction = historytransaction.GetStatusTransaction();
		return StatusTransaction;
	}

	public int GetMainWallet() {
		HomePage homepage = PageFactory.initElements(driver, HomePage.class);
		AccountInfoPage accountInfo = PageFactory.initElements(driver, AccountInfoPage.class);
		homepage.chooseAccount();
		String walletText = accountInfo.MainAmount.getText();
		String walletText1 = walletText.replace(",", "");
		int wallet = Integer.parseInt(walletText1);
		System.out.print(wallet);
		return wallet;
	}

	public String GetMessage() {
		String Message = accountInfo.MessageInfo.getText();
		System.out.print(Message);
		return Message;
	}
}

package Models;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.Constant;

public class mCommon {
	// Open browser Chrome
	public static void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
		Constant.driver = new ChromeDriver();
		Constant.driver.get(Constant.URL);
	}

	public void login() {
		// Pages.pLogin.loginLink.click();
		Constant.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Constant.driver.findElement(By.cssSelector("a#btnLogin")).click();
		// Pages.pLogin.phoneTxt.sendKeys(Pages.Constant.phone);
		// Pages.pLogin.nextBtn.click();
		// Constant.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// Pages.pLogin.pincodeTxt.sendKeys(Pages.Constant.pincode);
		Constant.driver.findElement(By.cssSelector("input[type = tel]")).sendKeys("0374441716");
		Constant.driver.findElement(By.xpath("//*[@id=\"signin-area\"]/div[3]/button/div")).click();
		Constant.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Constant.driver.findElement(By.cssSelector("div.pincode-field input")).sendKeys("123456");
		Constant.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void chooseTransactions() {
		Constant.driver.findElement(By.cssSelector("a#MainMenu_hlTrans")).click();
		Constant.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void chooseAccount() {
		Constant.driver.findElement(By.cssSelector("a#MainMenu_hlAccount")).click();
		Constant.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void chooseTopup() {
		Constant.driver.findElement(By.cssSelector("a.gdnt")).click();
		// Constant.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public String CheckTransactionHistory() {
		chooseTransactions();
		Constant.driver.findElement(By.cssSelector("select#MainContent_ddlTypeTransaction")).click();
		Constant.driver.findElement(By.cssSelector("#MainContent_ddlTypeTransaction > option:nth-child(9)")).click();
		Constant.driver.findElement(By.cssSelector("#MainContent_btSearch")).click();
		Constant.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Constant.driver.findElement(By.cssSelector("#MainContent_btSearch")).click();
		String StatusTransaction = Constant.driver.findElement(By.cssSelector("#tablelist > tbody > tr:nth-child(1) > td:nth-child(7)")).getText();
		System.out.print(StatusTransaction);
		return StatusTransaction;	
	}

	public int CheckWallet() {
		//Constant.driver.get("http://sandbox.senpay.vn/Business/Account/Info/");
		chooseAccount();
		String walletText = Constant.driver.findElement(By.cssSelector("#MainContent_lblAmount")).getText();
		String walletText1 = walletText.replace(",", "");
		int wallet = Integer.parseInt(walletText1);
		System.out.print(wallet);
		return wallet;
	}
	public String GetMessage() {
		String Message = Constant.driver.findElement(By.cssSelector("#DivInfoAccount > div:nth-child(1)")).getText();
		System.out.print(Message);
		return Message;
	}
}

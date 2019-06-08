package Models;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.Constant;

public class mTopup {

	public void chooseATMDomestic() {
		Constant.driver.findElement(By.cssSelector("div#domestic")).click();
	}

	public void chooseVCB() {
		Constant.driver.findElement(By.cssSelector("input[bankname=\"vietcombank\"]")).click();
	}

	public void InputAmount() {
		Constant.driver.findElement(By.cssSelector("input#txtAmount_Domestic")).sendKeys("10000");
	}

	public void AgreeTopup() {
		Constant.driver.findElement(By.cssSelector("#MainContent_Default1_ctl01_btnAgree")).click();
	}

	public void CancelTopup() {
		Constant.driver.findElement(By.cssSelector("#gateway > table > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(6) > td:nth-child(3) > img")).click();
	}

	public void InputValidInforATM() {
		Constant.driver.findElement(By.cssSelector("input#gateway_CardName")).sendKeys(Constant.CardName);
		Constant.driver.findElement(By.cssSelector("input#gateway_CardNumber")).sendKeys(Constant.CardNumber);
		Constant.driver.findElement(By.cssSelector("#CardMonth > option:nth-child(4)")).click();
		Constant.driver.findElement(By.cssSelector("#CardYear > option:nth-child(9)")).click();
		Constant.driver.findElement(By.cssSelector(
				"#gateway > table > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(6) > td:nth-child(4) > input[type=image]"))
				.click();
		Constant.driver.findElement(By.cssSelector("#verifyotp_OtpCode")).click();
		;
		Constant.driver.findElement(By.cssSelector("#CardYear > option:nth-child(9)")).click();
	}

	public void InputInValidInforATM() {
		Constant.driver.findElement(By.cssSelector("input#gateway_CardName")).sendKeys("Nguyen Van B");
		Constant.driver.findElement(By.cssSelector("input#gateway_CardNumber")).sendKeys(Constant.CardNumber);
		Constant.driver.findElement(By.cssSelector("#CardMonth > option:nth-child(4)")).click();
		Constant.driver.findElement(By.cssSelector("#CardYear > option:nth-child(9)")).click();

	}

	public void AgreeInforATM() {
		Constant.driver.findElement(By.cssSelector(
				"#gateway > table > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(6) > td:nth-child(4) > input[type=image]"))
				.click();
	}

}

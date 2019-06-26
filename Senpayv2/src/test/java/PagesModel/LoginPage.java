
package PagesModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	@FindBy (css = "input[type = tel]")
	WebElement txtPhone;
	@FindBy (css = "div.pincode-field input")
	WebElement txtPincode;
	@FindBy (css = "#signin-area > div:nth-child(4) > button > div > div > span")
	WebElement btnNext;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void InputPhone(String phone) {
		txtPhone.sendKeys(phone);
	}

	public void InputPin(String pin) {
		txtPincode.sendKeys(pin);
	}

	public void Next() {
		btnNext.click();
	}
	
	
}

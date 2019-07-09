package Senpay.pages;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

@DefaultUrl("https://senpay.vn/")

public class LoginPage extends PageObject {

	@FindBy (css = "input[type = tel]")
	WebElement txtPhone;
	@FindBy (css = "div.pincode-field input")
	WebElement txtPincode;
	@FindBy (css = "#signin-area > div:nth-child(4) > button > div > div > span")
	WebElement btnNext;

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

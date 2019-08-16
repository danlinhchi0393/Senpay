package com.senpay.serenity_cucumber.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

//@DefaultUrl("http://sandbox.senpay.vn")
//@DefaultUrl("http://stagging.senpay.vn")
@DefaultUrl("https://pilot.senpay.vn")

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
	
	public String GetNameAccount() {
		String Username = getDriver().findElement(By.cssSelector("div.login strong")).getText();
		return Username;
	}
}
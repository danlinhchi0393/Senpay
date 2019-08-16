package com.senpay.serenity_cucumber.pages;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import net.serenitybdd.core.pages.WebElementFacade;
import java.util.stream.Collectors;

import net.serenitybdd.core.annotations.findby.FindBy;

import net.thucydides.core.pages.PageObject;

import java.util.List;

//@DefaultUrl("https://senpay.vn/")
public class LinkVTB extends PageObject {
	@FindBy(css = "a#MainMenu_hlTrans")
	WebElement TabTransaction;
	
	
	
	public void chooseWithdraw() {
		
	}
}
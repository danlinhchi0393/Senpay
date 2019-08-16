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
public class LinkVTBPage extends PageObject {
	@FindBy(css = "#MainContent_drbankname option[value=\"9\"]")
	WebElement ChooseLinkVTB;
	@FindBy(css = "input#MainContent_txtNumberCard")
	WebElement NumberCard_vtb;
	
	@FindBy(css = "#MainContent_ddlIssueMonth > option:nth-child(11)")
	WebElement MonthCard_vtb;
	
	@FindBy(css = "#MainContent_ddlIssueYear > [value =\"17\"]")
	WebElement YearCard_vtb;
	@FindBy(css = "input#MainContent_txtCMTCard")
	WebElement CMTCard;
	
	public void Choose_LinkVTB() {
		
	}
}
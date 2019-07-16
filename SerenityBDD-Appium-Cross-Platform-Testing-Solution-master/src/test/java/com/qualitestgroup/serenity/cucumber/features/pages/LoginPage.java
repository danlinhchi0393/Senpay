package com.qualitestgroup.serenity.cucumber.features.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{


    @AndroidFindBy(id = "com.google.android.apps.messaging:id/conversation_snippet")
    @FindBy(xpath = "//XCUIElementTypeApplication[@name=\"my giffgaffβ\"]/XCUIElementTypeWindow[1]/XCUIElementTypeScrollView/XCUIElementTypeTextField")
    private WebElement usernameField;

    
    // Login
    public String Get_text(){
    	String OTP = usernameField.getText();
        return OTP;
    }

    
}

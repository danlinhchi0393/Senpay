package com.senpay.serenity_cucumber.steps.serenity;



import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;


import java.util.concurrent.TimeUnit;



import com.senpay.serenity_cucumber.pages.HomePage;
import com.senpay.serenity_cucumber.pages.LoginPage;



public class LoginSteps extends ScenarioSteps  {

   LoginPage loginPage;
   HomePage homepage;
   
    @Step
    public void choose_topup() {
        homepage.chooseTransactions();
        homepage.chooseTopup();
    }
    
    @Step
    public void is_the_login_page() {
    	loginPage.open();
    	getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    
    @Step
    public void enters_phone(String phone) {
        loginPage.InputPhone(phone);
    }
    
    @Step
    public void enters_pincode(String pincode) {
        loginPage.InputPin(pincode);
    }

    @Step
    public void next_login() {
    	loginPage.Next();
    	getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    

    @Step
    public void login_with(String phone, String pincode) {
    	getDriver().findElement(By.cssSelector("a#btnLogin")).click();
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	enters_phone(phone);
    	next_login();
        enters_pincode(pincode);
    }
    @Step
    public String get_name_account() {
    	return loginPage.GetNameAccount();
    }

   
    
}
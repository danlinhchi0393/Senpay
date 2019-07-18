package com.senpay.serenity_cucumber.steps.serenity;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.Is.is;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.senpay.serenity_cucumber.pages.AccountInfoPage;
import com.senpay.serenity_cucumber.pages.HomePage;
import com.senpay.serenity_cucumber.pages.LoginPage;

import static org.hamcrest.Matchers.hasItem;

public class AccountInforSteps extends ScenarioSteps   {

    
	AccountInfoPage accountinfor;
	HomePage homepage;
    
    @Step
    public int get_main_total_balance() {
    	homepage.chooseAccount();
         //homepage.chooseInfor_account();
    	int total_balance = accountinfor.CheckWallet();
        return total_balance;
    }
  
    
}
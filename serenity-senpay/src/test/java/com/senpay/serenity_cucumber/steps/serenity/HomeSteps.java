package com.senpay.serenity_cucumber.steps.serenity;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.Is.is;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.senpay.serenity_cucumber.pages.HomePage;
import com.senpay.serenity_cucumber.pages.LoginPage;

import static org.hamcrest.Matchers.hasItem;

public class HomeSteps extends ScenarioSteps   {

    
    HomePage homepage;
    
    @Step
    public void choose_topup() {
        homepage.chooseTransactions();
        homepage.chooseTopup();
    }
    
}
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
import com.senpay.serenity_cucumber.pages.TopupPage;

import static org.hamcrest.Matchers.hasItem;

public class TopupSteps extends ScenarioSteps   {

    
    TopupPage topup;
    
    @Step
    public void choose_topup_by_link_BIDV(String topup_amount) {
        topup.Choose_link_BIDV();
        topup.InputAmount_BIDV(topup_amount);
    }
    
}
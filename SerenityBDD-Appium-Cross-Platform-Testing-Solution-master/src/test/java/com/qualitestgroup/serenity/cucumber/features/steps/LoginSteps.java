package com.qualitestgroup.serenity.cucumber.features.steps;

import com.qualitestgroup.serenity.cucumber.features.pages.LoginPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;

public class LoginSteps extends ScenarioSteps {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginSteps.class);

    private LoginPage loginPage;

    @Step
    public void verifyLoginFormShown(){
        LOGGER.info("Verifying log in form is displayed.");
       loginPage.Get_text();
    }
}

    

package com.senpay.serenity_cucumber;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/features/Topup.feature",tags = "@Unauthenticated")
public class TopupTestSuite {}

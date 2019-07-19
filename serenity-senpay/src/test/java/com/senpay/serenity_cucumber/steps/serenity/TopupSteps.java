package com.senpay.serenity_cucumber.steps.serenity;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.Is.is;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import com.senpay.serenity_cucumber.pages.HomePage;
import com.senpay.serenity_cucumber.pages.LoginPage;
import com.senpay.serenity_cucumber.pages.TopupPage;

import static org.hamcrest.Matchers.hasItem;

public class TopupSteps extends ScenarioSteps {

	TopupPage topup;

	@Step
	public void choose_topup_by_link_BIDV_with(String topup_amount) {
		topup.Choose_link_BIDV();
		topup.InputAmount_BIDV(topup_amount);
		topup.Choose_Agree_BIDV_button();
	}

	@Step
	public void choose_submit_topup_by_link_BIDV_with(String OTPvalue) {
		topup.Input_OTP(OTPvalue);
		topup.Choose_submit_bidv();
	}

	@Step
	public boolean Check_message_input_invalid_OTP(String expect) {
		String actual_message = topup.Get_error_message();
		System.out.print(actual_message);
		if (actual_message.contentEquals(expect) == true)
			return true;
		return false;
	}
		@Step
		public boolean Check_result_message(String expect) {
			getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			String actual_result_message = topup.Get_result_message();
			//System.out.print(actual_result_message);
			if (actual_result_message.contentEquals(expect) == true)
				return true;
			return false;
	}
		@Step
		public boolean Check_message_validate_limit(String expect) {
			getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			String message_validate_limit = topup.Get_message_validate_limit();
			//System.out.print(actual_result_message);
			if (message_validate_limit.contentEquals(expect) == true)
				return true;
			return false;
	}
		
		@Step
		public void add_tab() {
			String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,"t");
			getDriver().findElement(By.tagName("body")).sendKeys(selectLinkOpeninNewTab);

			getDriver().get("www.facebook.com");
			getDriver().findElement(By.tagName("body")).sendKeys(Keys.CONTROL,"\t");
			String title = getDriver().getTitle();
			System.out.print(title);
			getDriver().navigate().refresh();
		}
}
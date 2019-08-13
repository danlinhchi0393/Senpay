package com.senpay.serenity_cucumber.steps.serenity;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.Is.is;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;

import com.senpay.serenity_cucumber.pages.HomePage;
import com.senpay.serenity_cucumber.pages.LoginPage;
import com.senpay.serenity_cucumber.pages.TopupPage;

import cucumber.api.java.it.Data;

import static org.hamcrest.Matchers.hasItem;

public class TopupSteps extends ScenarioSteps {

	TopupPage topup;
	@Step
	public void choose_topup_by_link_BIDV() {
		topup.Choose_link_BIDV();
	}
	@Step
	public void choose_topup_by_link_VTB() {
		topup.Choose_link_VTB();
	}
	@Step
	public void choose_topup_by_link_with(String amount) {
		topup.InputAmount_BIDV(amount);
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
		public boolean Check_message_finish_transaction(String expect) {
			getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			String message_finish_transaction = topup.Get_message_finish_transaction();
			//System.out.print(actual_result_message);
			if (message_finish_transaction.contentEquals(expect) == true)
				return true;
			return false;
	}
		@Step
		public boolean Check_message_invalid_transaction(String expect) {
			getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			String message_invalid_OTP_5times = topup.Get_message_invalid_transaction();
			//System.out.print(actual_result_message);
			if (message_invalid_OTP_5times.contentEquals(expect) == true)
				return true;
			return false;
	}
		
		@Step
		public void add_tab() {
			//String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,"t");
			//getDriver().findElement(By.tagName("body")).sendKeys(selectLinkOpeninNewTab);
			Actions act = new Actions(getDriver());
			act.keyDown(Keys.CONTROL).sendKeys("t").keyUp(Keys.CONTROL).build().perform();
			getDriver().get("https://www.google.com");
			getDriver().findElement(By.tagName("body")).sendKeys(Keys.CONTROL,"\t");
			String title = getDriver().getTitle();
			System.out.print(title);
			getDriver().navigate().refresh();
		}
		
		@Step
		 public void takeSnapShot() throws IOException {
			 TakesScreenshot scrShot =((TakesScreenshot)getDriver());

		        //Call getScreenshotAs method to create image file

		                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		                Date date=java.util.Calendar.getInstance().getTime();  
		                System.out.println(date); 
		               String folder=" e://test//";
		            //Move image file to new destination
		               String fileWithPath  = folder+date;
		                File DestFile=new File(fileWithPath);

		                //Copy file at destination

		                FileUtils.copyFile(SrcFile, DestFile);

		}
}
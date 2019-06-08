package Testcase;

import org.testng.annotations.Test;

import Pages.Constant;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;

public class TCLogin {
	Models.mLogin Ologin = new Models.mLogin();

	@Test
	public void LoginSuccess() {
		Ologin.login();
		String Username = Constant.driver.findElement(By.cssSelector("div.login strong")).getText();
		AssertJUnit.assertEquals("nguyen dan linh chi", Username);
	}

	@Test
	public void LoginFail() {
		Ologin.login();
		String Username = Constant.driver.findElement(By.cssSelector("div.login strong")).getText();
		AssertJUnit.assertEquals("nguyen dan linh chi1", Username);
	}

	@BeforeTest
	public void beforeTest() {
		Ologin.openBrowser();

	}

	@AfterTest
	public void Close_window() {
		Constant.driver.close();
	}

}

package Testcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import PagesModel.LoginPage;
import base.InstanciateDriver;

public class TCLogin extends InstanciateDriver{
	
	@Test
	public void LoginSuccess() throws Exception {
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		driver.findElement(By.cssSelector("a#btnLogin")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		login.InputPhone("0374441716");
		login.Next();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		login.InputPin("123456");
		String Username = this.driver.findElement(By.cssSelector("div.login strong")).getText();
		AssertJUnit.assertEquals("nguyen dan linh chi", Username);
	}
}
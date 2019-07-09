package Senpay.steps.serenity;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import net.thucydides.core.steps.ScenarioSteps;
import Senpay.pages.LoginPage;

public class UserLoginSteps extends ScenarioSteps {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	LoginPage loginpage;

	public void OpenBrowser() {
		loginpage.open();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public void LoginSuccess(String phone, String pin) {
		getDriver().findElement(By.cssSelector("a#btnLogin")).click();
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		loginpage.InputPhone(phone);
		loginpage.Next();
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		loginpage.InputPin(pin);
	}
	
	public String GetNameAccount() {
		String Username = getDriver().findElement(By.cssSelector("div.login strong")).getText();
		return Username;
	}

}

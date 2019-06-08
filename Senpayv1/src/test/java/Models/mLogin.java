package Models;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


import Pages.Constant;
import Pages.pLogin;

public class mLogin {
	//Open browser Chrome
	
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
	Constant.driver=new ChromeDriver();
	Constant.driver.get(Constant.URL);
	}
	
	// login sanbox
	public void login() {
		//Pages.pLogin.loginLink.click();
		Constant.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Constant.driver.findElement(By.cssSelector("a#btnLogin")).click();
        //Pages.pLogin.phoneTxt.sendKeys("0374441716");
        
		//Pages.pLogin.nextBtn.click();
		//Constant.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//Pages.pLogin.pincodeTxt.sendKeys(Pages.Constant.pincode);
		//Constant.driver.findElement(By.cssSelector("input[type = tel]")).sendKeys("0374441716");
		//Constant.driver.findElement(pLogin.txtPhone).sendKeys("0374441716");
		Constant.driver.findElement(By.xpath("//*[@id=\"signin-area\"]/div[3]/button/div")).click();
		Constant.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Constant.driver.findElement(By.cssSelector("div.pincode-field input")).sendKeys("123456");
		Constant.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}

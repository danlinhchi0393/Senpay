
package Pages;

import Pages.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class pLogin {
	
	// public static WebElement loginLink =
	// pages.Constant.driver.findElement(By.cssSelector("#btnLogin"));
	// public static WebElement phoneTxt =
	// Constant.driver.findElement(By.cssSelector("input[type = tel]"));
	public static WebElement phoneTxt = Pages.Constant.driver.findElement(By.xpath("//input[@type='tel']"));
	// public static WebElement phoneChangeBtn =
	// pages.Constant.driver.findElement(By.xpath("//span[contains(text(),'SĐT
	// KHÁC')]"));

	public static WebElement nextBtn = Constant.driver.findElement(By.xpath("//*[@id=\"signin-area\"]/div[3]/button/div"));
	public static WebElement pincodeTxt = Constant.driver.findElement(By.cssSelector("div.pincode-field input"));

}



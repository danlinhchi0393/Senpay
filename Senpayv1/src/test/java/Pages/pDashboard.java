

package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class pDashboard {
	//public static WebElement loginLink = pages.Constant.driver.findElement(By.cssSelector("#btnLogin"));
	public static WebElement phoneTxt = Pages.Constant.driver.findElement(By.cssSelector("input[type = tel]"));
	//public static WebElement phoneChangeBtn = pages.Constant.driver.findElement(By.xpath("//span[contains(text(),'SĐT KHÁC')]"));
	
	public static WebElement nextBtn = Pages.Constant.driver.findElement(By.xpath("//*[@id=\"signin-area\"]/div[3]/button/div"));
	public static WebElement pincodeTxt = Pages.Constant.driver.findElement(By.cssSelector("div.pincode-field input"));
	
}

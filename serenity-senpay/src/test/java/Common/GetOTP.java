package Common;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.annotations.findby.By;


 
public class GetOTP {

	public static String GetOTP_From_Senpay() throws MalformedURLException {
		
		//Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "My Phone");
		caps.setCapability("udid", "0123456789ABCDEF"); //Give Device ID of your mobile phone
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "4.4.2");
		caps.setCapability("appPackage", "com.google.android.apps.messaging");
		caps.setCapability("appActivity", "com.google.android.apps.messaging.ui.ConversationListActivity");
		caps.setCapability("noReset", "true");
		
		//Instantiate Appium Driver
		//try {
		AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
			
		//} catch (MalformedURLException e) {
		//	System.out.println(e.getMessage());
		//}
		//driver.findElementById("com.google.android.apps.messaging:id/swipeableContainer").click();
		//String OTPValue = driver.findElementById("com.google.android.apps.messaging:id/conversation_snippet").getText().substring(0, 6);
		String OTPValue= driver.findElement(By.id("com.google.android.apps.messaging:id/conversation_snippet")).getText().substring(0, 6);
		return OTPValue;
		
	}
public static String GetOTP_From_BIDV() throws MalformedURLException {
		
		//Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "My Phone");
		caps.setCapability("udid", "0123456789ABCDEF"); //Give Device ID of your mobile phone
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "4.4.2");
		caps.setCapability("appPackage", "com.google.android.apps.messaging");
		caps.setCapability("appActivity", "com.google.android.apps.messaging.ui.ConversationListActivity");
		caps.setCapability("noReset", "true");
		AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		String Message = driver.findElementById("com.google.android.apps.messaging:id/conversation_snippet").getText();
		System.out.print(Message);
		String Compare = "nhap OTP";
		System.out.print(Compare);
		int index = Message.indexOf(Compare);
		String OTPValue = Message.substring(index+8, index+14);
		System.out.print(OTPValue);
				return OTPValue;
		
	}
 
}


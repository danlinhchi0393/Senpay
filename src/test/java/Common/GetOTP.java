package Common;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;



 
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
		//caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
		//} catch (MalformedURLException e) {
		//	System.out.println(e.getMessage());
		//}
		//driver.findElementById("com.google.android.apps.messaging:id/swipeableContainer").click();
		//String OTPValue = driver.findElementById("com.google.android.apps.messaging:id/conversation_snippet").getText().substring(0, 6);
		//String OTPValue= driver.findElement(By.id("com.google.android.apps.messaging:id/conversation_snippet")).getText().substring(0, 6);
		//String OTPValue = driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().resourceId(\"%s\")", "com.google.android.apps.messaging:id/conversation_snippet"))).getText();
		
		String OTPValue = driver.findElement(By.xpath("//android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]")).getText().substring(0, 6);
		//System.out.print(OTPValue);
		//String OTPValue = driver.findElementsByAndroidUIAutomator("new UiSelector().resourceId("com.google.android.apps.messaging:id/conversation_snippet")");
		return OTPValue;
		
	}
public static String GetOTP_From_BIDV() throws MalformedURLException {
		
		//Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "My Phone");
		caps.setCapability("udid", "0123456789ABCDEF"); //may chindl
		//caps.setCapability("platformVersion", "4.4.2");
		//caps.setCapability("udid", "3300ccd2ec94c405"); // android trăng
		caps.setCapability("platformVersion", "8.1.0");
		caps.setCapability("platformName", "Android");
		
		caps.setCapability("appPackage", "com.google.android.apps.messaging");
		caps.setCapability("appActivity", "com.google.android.apps.messaging.ui.ConversationListActivity");
		caps.setCapability("noReset", "true");
		AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		String Message = driver.findElement(By.xpath("//android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]")).getText();
		//Tin nhăn trong máy android trắng
		//String Message = driver.findElement(By.xpath("//android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView[2]")).getText();
		//System.out.print(Message);
		String Compare = "nhap OTP";
		int index = Message.indexOf(Compare);
		//System.out.print(index);
		String OTPValue = Message.substring(index+9, index+15);
		//System.out.print(OTPValue);
				return OTPValue;
		
	}
public static String Get_message_transaction_From_BIDV() throws MalformedURLException {
	
	//Set the Desired Capabilities
	DesiredCapabilities caps = new DesiredCapabilities();
	caps.setCapability("deviceName", "My Phone");
	caps.setCapability("udid", "0123456789ABCDEF"); //may chindl
	//caps.setCapability("platformVersion", "4.4.2");
	//caps.setCapability("udid", "3300ccd2ec94c405"); // android trăng
	caps.setCapability("platformVersion", "8.1.0");
	caps.setCapability("platformName", "Android");
	
	caps.setCapability("appPackage", "com.google.android.apps.messaging");
	caps.setCapability("appActivity", "com.google.android.apps.messaging.ui.ConversationListActivity");
	caps.setCapability("noReset", "true");
	AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
	String Message = driver.findElement(By.xpath("//android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]")).getText();
	//Tin nhăn trong máy android trắng
	//String Message = driver.findElement(By.xpath("//android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView[2]")).getText();
	//System.out.print(Message);
	String Compare = "tai BIDV";
	int index = Message.indexOf(Compare);
	//System.out.print(index);
	String transaction_amount = Message.substring(index+9, index+19);
	System.out.print(transaction_amount);
			return transaction_amount;
	
} 

public static String GetOTP_From_Viettinbank_link() throws MalformedURLException {
	
	//Set the Desired Capabilities
	DesiredCapabilities caps = new DesiredCapabilities();
	caps.setCapability("deviceName", "My Phone");
	caps.setCapability("udid", "0123456789ABCDEF"); //may chindl
	//caps.setCapability("platformVersion", "4.4.2");
	//caps.setCapability("udid", "3300ccd2ec94c405"); // android trăng
	caps.setCapability("platformVersion", "8.1.0");
	caps.setCapability("platformName", "Android");
	
	caps.setCapability("appPackage", "com.google.android.apps.messaging");
	caps.setCapability("appActivity", "com.google.android.apps.messaging.ui.ConversationListActivity");
	caps.setCapability("noReset", "true");
	AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
	String Message = driver.findElement(By.xpath("//android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]")).getText();
	//Tin nhăn trong máy android trắng
	//String Message = driver.findElement(By.xpath("//android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView[2]")).getText();
	//System.out.print(Message);
	String Compare = "Ma OTP";
	int index = Message.indexOf(Compare);
	//System.out.print(index);
	String OTPValue = Message.substring(index+7, index+13);
	//System.out.print(OTPValue);
			return OTPValue;
	
}
}


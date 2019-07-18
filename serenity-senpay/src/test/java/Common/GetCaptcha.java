package Common;

import java.io.File;
import java.io.IOException;
import org.testng.annotations.Test;
import com.asprise.ocr.Ocr;

public class GetCaptcha  
{  
	@Test
	public void start() throws IOException
	{
		Ocr ocr = new Ocr(); // create a new OCR engine
		ocr.startEngine("eng", Ocr.SPEED_FASTEST); // English
		// path of the image
        	String s = ocr.recognize(new File[] { new File("C:\\Users\\NamPK\\Desktop\\AUTO_SENPAY\\captcha\\captcha.jpg") },
		Ocr.RECOGNIZE_TYPE_TEXT, Ocr.OUTPUT_FORMAT_PLAINTEXT);
		System.out.println(s);
		ocr.stopEngine(); // Stop OCR engine
	}  
}
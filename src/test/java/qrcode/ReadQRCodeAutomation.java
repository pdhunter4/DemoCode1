package qrcode;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.oned.MultiFormatOneDReader;

public class ReadQRCodeAutomation {
	
	
	public static void main(String[] args) throws IOException, NotFoundException {
		
		/*
		 * This is to read the QR code present in the application 
		 * Mvn Repository : Zxing Java SE Extensions
		 * 					Zxing Core
		 */
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://testautomationpractice.blogspot.com/");
		
		// This will extract the value of src from the qrcode image
		String qrcodeURL = driver.findElement(By.xpath("//div[@id='HTML4']/div[1]/img")).getAttribute("src");
		
		// First check the url of the image
		URL url = new URL(qrcodeURL);
		BufferedImage bufferedImage = ImageIO.read(url);	//now read the url to capture the qrcode image 
		
		//Using BufferedImage we have created a luminance source
		LuminanceSource luminanceSource = new BufferedImageLuminanceSource(bufferedImage);
		//By using luminance source we have create a binary bitmap
		BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(luminanceSource));
		
		//T result object will contains the contents of the qrcode
		Result result = new MultiFormatReader().decode(binaryBitmap);
		
		System.out.println(result.getText());
		
	}

}

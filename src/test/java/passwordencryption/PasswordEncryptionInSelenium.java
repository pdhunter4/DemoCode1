package passwordencryption;

import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PasswordEncryptionInSelenium {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/#/index");
		
		String password = passwordEncoding("Mtech123$");
		
		driver.findElement(By.cssSelector("a[href*='sign_in']")).click();
		driver.findElement(By.id("user_email")).sendKeys("prathameshqa1990@gmail.com");
		driver.findElement(By.id("user_password")).sendKeys(passwordDecoding(password));
		driver.findElement(By.name("commit")).click();
		
	}
	
	static String passwordDecoding(String password) {
		byte[] decodedValue = Base64.decodeBase64(password.getBytes());
		return new String(decodedValue);
	}
	
	static String passwordEncoding(String password) {
		byte[] encodedValue = Base64.encodeBase64(password.getBytes());
		return new String(encodedValue);
	}

}

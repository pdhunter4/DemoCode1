package imagecompare;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class DownloadImageAshotAPI {

	public static void main(String[] args) throws IOException, InterruptedException {

		/*
		 * Comparing images using AShot API
		 * 
		 * 1. Yandex QATools Ashot WebDriver Utility 
		 *    URL : https://mvnrepository.com/artifact/ru.yandex.qatools.ashot/ashot/1.5.4
		 *    
		 * 2. Hamcrest All from Maven Repository
		 * 
		 * 3. Gson from Maven Repository
		 */
		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/#/index");
		
		// To capture the image and store at desired location
		WebElement logo = driver.findElement(By.xpath("/html/body/app-root/div/header/div[2]/div/div/div[1]/div/a/img"));
		Screenshot logoScreenShot = new AShot().takeScreenshot(driver, logo);
		
		ImageIO.write(logoScreenShot.getImage(), "png", new File(System.getProperty("user.dir") + 
															"\\src\\test\\java\\imagecompare\\rsa_logo.png"));
		//verify the image is stored in the defined location
		File f = new File(System.getProperty("user.dir") + "\\src\\test\\java\\imagecompare\\rsa_logo.png");
		if(f.exists())
			System.out.println("Image captured and stored at desired location");
		else
			System.out.println("Image file do not exists at the desired location");
		
		// Now we will verify the downloaded image matches with the logo image in the application
		
		

	}

}

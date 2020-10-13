package imagecompare;

import java.awt.image.BufferedImage;
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
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class CompareImages {

	public static void main(String[] args) throws IOException, InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/#/index");
		
		// To read the image present locally 
		BufferedImage expectedImage = ImageIO.read(new File(System.getProperty("user.dir") 
									+ "\\src\\test\\java\\imagecompare\\rsa_logo.png"));
		
		// now capture the image from the application and save it with different name
		WebElement logo = driver.findElement(By.xpath("/html/body/app-root/div/header/div[2]/div/div/div[1]/div/a/img"));
		Screenshot logoScreenshot = new AShot().takeScreenshot(driver, logo);
		
		ImageIO.write(logoScreenshot.getImage(), "png", new File(System.getProperty("user.dir") + 
				"\\src\\test\\java\\imagecompare\\rsa_logo1.png"));
		BufferedImage actualImage = ImageIO.read(new File(System.getProperty("user.dir") 
				+ "\\src\\test\\java\\imagecompare\\rsa_logo.png"));
		
		// to compare images we have a class called ImageDiffer
		ImageDiffer imageDifference = new ImageDiffer();
		//This ImageDiff class object will store the actual result difference in the image
		ImageDiff difference = imageDifference.makeDiff(expectedImage, actualImage);
		
		// The below condition checks that both image has any difference
		if(difference.hasDiff() == true)			// true = Images are different
			System.out.println("Images are different");
		else
			System.out.println("Images are identical");  	// false = Images are same
		
		driver.close();
		
		//delete the image after comparison
		File f = new File(System.getProperty("user.dir") + 
				"\\src\\test\\java\\imagecompare\\rsa_logo1.png");
		if(f.exists()) {
			f.delete();
		}

	}

}

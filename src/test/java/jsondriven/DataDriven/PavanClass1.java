package jsondriven.DataDriven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PavanClass1 {
	
	WebDriver driver;
	
	
	@BeforeMethod
	public void initializeWebDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}
	
	
	@Test(dataProviderClass = DataProviderJSON.class,dataProvider = "getJSONData")
	public void loginTest(String credentials) {
		driver.get("https://admin-demo.nopcommerce.com/");
		WebElement email = driver.findElement(By.id("Email"));
		WebElement password = driver.findElement(By.id("Password"));
		email.clear();
		email.sendKeys(credentials.split(",")[0].trim());
		password.clear();
		password.sendKeys(credentials.split(",")[1].trim());
		driver.findElement(By.xpath("//input[contains(@class,'login-button')]")).click();
		
		String title = driver.getTitle();
		Assert.assertEquals(title, "Dashboard / nopCommerce administration");
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	

}

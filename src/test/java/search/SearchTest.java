package search;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class SearchTest {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://testautomationpractice.blogspot.com/");
		
		WebElement searchField = driver.findElement(By.id("Wikipedia1_wikipedia-search-input"));
		searchField.sendKeys("Selenium");
		//searchField.sendKeys(Keys.ENTER);
/*		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("a[href*='Selenium_(software)']")));
		
		List<WebElement> searchedLinks = driver.findElements(By.id("wikipedia-search-result-link"));
		
		
		for(int i=0;i<searchedLinks.size();i++) {
			if(searchedLinks.get(i).getText().contentEquals("Selenium (software)")) {
				searchedLinks.get(i).click();
				break;
			}
		}
		
		Thread.sleep(5000L);
		String redirectingWindow = driver.getWindowHandle();
		driver.switchTo().window(redirectingWindow);
		String redirectedPageTitle = driver.getTitle();
		
		Assert.assertEquals(redirectedPageTitle, "Selenium (software) - Wikipedia");
		driver.close();
		System.out.println(driver.getTitle());*/
		
	}

}

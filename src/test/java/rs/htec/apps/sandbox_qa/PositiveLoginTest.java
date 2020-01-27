package rs.htec.apps.sandbox_qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class PositiveLoginTest {

	public void loginTest() {

		WebDriver driver = initializeDriver();

		loginCredentials(driver);

		verification(driver);

		driver.quit();

	}

	private void verification(WebDriver driver) {
		
		Assert.assertTrue(driver.findElement(By.xpath("//nav[@class='navbar navbar-expand-sm navbar-light']")).isDisplayed());
		
		
	}

	private void loginCredentials(WebDriver driver) {
		WebElement LoginButton = driver.findElement(By.xpath("//a[@class='btn btn-lg btn-secondary']"));
		LoginButton.click();

		/*
		 * String ExpectedUrl = "https://qa-sandbox.apps.htec.rs/login"; String
		 * ActualUrl = driver.getCurrentUrl(); Assert.assertEquals(ExpectedUrl,
		 * ActualUrl, "Actual url is not the same as expected!");
		 */
		WebElement Email = driver.findElement(By.cssSelector("input[name='email']"));
		Email.sendKeys("stefanstefanovic990@gmail.com");

		WebElement Password = driver.findElement(By.cssSelector("input[name='password']"));
		Password.sendKeys("123456");

		WebElement Submit = driver.findElement(By.cssSelector("form > .btn.btn-block.btn-primary.mt-4"));
		Submit.click();
		
		
		
	}

	private WebDriver initializeDriver() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://qa-sandbox.apps.htec.rs/");
		return driver;
	}

}

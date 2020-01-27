package rs.htec.apps.sandbox_qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class ForgotPasswordNegativeTest {
	
	public void negative() {
		
		
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://qa-sandbox.apps.htec.rs/");
		
		WebElement ForgotPassword = driver.findElement(By.cssSelector(".btn.btn-lg.btn-primary.mr-2"));
		ForgotPassword.click();
		
		String ActualUrl = driver.getCurrentUrl();
		String ExpectedUrl = "https://qa-sandbox.apps.htec.rs/forgot-password";
		
		Assert.assertEquals(ActualUrl, ExpectedUrl, "Actual url is not the same as expect");
		
		WebElement Email = driver.findElement(By.cssSelector("input[name='email']"));
		Email.sendKeys("test");
		
		WebElement Submit = driver.findElement(By.cssSelector("form > .btn.btn-primary.float-right.mt-4"));
		Submit.click();
		
		Assert.assertTrue(driver.findElement(By.cssSelector(".invalid-feedback")).isDisplayed());
				
		driver.close();
		
		
		
		
	}

}

package rs.htec.apps.sandbox_qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class NegativeLoginTest {
	
	
	public void negativeData () {
		
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://qa-sandbox.apps.htec.rs/");
		
		WebElement LoginButton = driver.findElement(By.xpath("//a[@class='btn btn-lg btn-secondary']"));
		LoginButton.click();
		
		WebElement Email = driver.findElement(By.cssSelector("input[name='email']"));
		Email.sendKeys("test@gmail.com");
		
		WebElement Password = driver.findElement(By.cssSelector("input[name='password']"));
		Password.sendKeys("987321");
		
		WebElement Submit = driver.findElement(By.cssSelector("form > .btn.btn-block.btn-primary.mt-4"));
		Submit.click();

			
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='invalid-feedback']")).isDisplayed());
		
		
		driver.close();	
			
		}
		
	 
	}



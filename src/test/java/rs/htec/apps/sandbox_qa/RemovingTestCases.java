package rs.htec.apps.sandbox_qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class RemovingTestCases {

	public void Remove() {

		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://qa-sandbox.apps.htec.rs/");

		WebElement LoginButton = driver.findElement(By.xpath("//a[@class='btn btn-lg btn-secondary']"));
		LoginButton.click();

		WebElement Email = driver.findElement(By.cssSelector("input[name='email']"));
		Email.sendKeys("stefanstefanovic990@gmail.com");

		WebElement Password = driver.findElement(By.cssSelector("input[name='password']"));
		Password.sendKeys("123456");

		WebElement UseCases = driver
				.findElement(By.cssSelector(".row > div:nth-of-type(2) .card-title.pb-3.text-center"));
		UseCases.click();

		WebElement FirstTest = driver.findElement(By.cssSelector(".list-group.mt-5 > a:nth-of-type(1)"));
		FirstTest.click();
		WebElement DeleteFirstTest = driver.findElement(
				By.cssSelector(".btn.btn-dark.btn-lg.btn-secondary.mb-3.ml-2.pull-right > .fa-trash-alt.far"));
		DeleteFirstTest.click();
		Assert.assertTrue(driver.findElement(By.cssSelector("//div[@class='text-muted lead']")).isDisplayed());
		WebElement DeleteButton = driver.findElement(By.cssSelector(".btn.btn-danger.btn-lg"));
		DeleteButton.click();
		
		
		
	}

}

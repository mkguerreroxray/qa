package iMoneyTransTestCasesAllBrowsers;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Methods.randomMailGenerator;
import Methods.randomNumberGenarator;
import iMoneyTransObjectRepository.RegisterPage;

public class RegisterTestonProd {

	@Test(enabled = false)
	public void RegisterTesting() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\eclipse\\chromedriver\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().window().maximize();
		driver.get("https://www.moneytrans.eu/belgium/en/register");

		RegisterPage RPage = new RegisterPage(driver);
		randomMailGenerator RndmMail = new randomMailGenerator();

		String Email = (RndmMail.getSaltString() + "@gmail.com");

		System.out.println(Email);

		RPage.Email().sendKeys(Email);

		RPage.ConfirmEmail().sendKeys(Email);

		driver.findElement(By.xpath("//a[contains(.,'ACCEPT')]")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		jse.executeScript("arguments[0].click();", RPage.CreateAccountButton());

		wait.until(ExpectedConditions.elementToBeClickable(RPage.FirstName()));

		// RPage.SelectCountry().click();

		// RPage.Belgium().click();

		RPage.FirstName().sendKeys(RndmMail.getSaltString());

		RPage.LastName().sendKeys(RndmMail.getSaltString());

		RPage.DateofBirth().click();

		RPage.DateofBirth().sendKeys("01102003");

		RPage.DateofBirth().sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		randomNumberGenarator RndmNmb = new randomNumberGenarator();
		Thread.sleep(1000);

		RPage.Phone().sendKeys("+32" + RndmNmb.createRandomNumber(8));

		RPage.Password().sendKeys(RndmMail.getSaltString() + RndmNmb.createRandomNumber(4));

		RPage.JoinNow().click();

		if (RPage.HeaderValid().isDisplayed() == true) {

			Assert.assertTrue(true);
			driver.quit();

		} else {

			Assert.assertTrue(false);
		}

	}
}

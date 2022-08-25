package MultiservicesTestCasesAllBrowsers;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import AllureListener.AllureListenerMultiServices;
import MultiservicesObjectRepository.TestBase;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Listeners({ AllureListenerMultiServices.class })
public class MultiservicesInternationalMobileTopUpTest extends TestBase {
	@Test
	@Severity(SeverityLevel.CRITICAL)
	public void BE_Multiservices_International_Mobile_Top_Up_Test() throws Exception {

		// LOGIN
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement Username = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='User name (login)']")));
		Username.sendKeys("product");
		WebElement Password = driver.findElement(By.xpath(
				"//*[@id=\"login-wrapper\"]/div[2]/form/nz-form-item[2]/nz-form-control/div/span/nz-input-group/input"));
		Password.sendKeys("test");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

		// BENEFICIARY
		WebElement International_pop_up = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//div[@class=\"product-display-name col-xs-10\"])[2]")));
		International_pop_up.click();

		WebElement Sender_phone = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"emitPhone\"]")));
		Sender_phone.clear();
		Sender_phone.sendKeys("+628123456710");
		Thread.sleep(2000);

		WebElement Destination_Country = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@role=\"combobox\"]")));
		Destination_Country.click();
		Thread.sleep(2000);

		wait.until(ExpectedConditions.elementToBeClickable(driver
				.findElement(By.xpath("//div[@class=\"ng-dropdown-panel-items scroll-host\"]/div/div[98]/div/span"))))
				.click();
		Thread.sleep(2000);

		driver.findElement(By.id("benefPhone")).clear();
		driver.findElement(By.id("benefPhone")).sendKeys("+628123456710");
		wait.until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.xpath("(//span[text()=\" Continue \"])[1]")))).click();

		// TOP-UP
		WebElement Six_EUR = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()=\"5.000,00 IDR\"]")));
		Six_EUR.click();
		driver.findElement(By.xpath("(//span[text()=\" Continue \"])[2]")).click();
		Thread.sleep(2000);

		// AMOUTH VALIDATION
		if (driver.findElements(By.xpath("//h3[text()=\" TOTAL TO PAY 0,10 EUR \"]")).size() != 0) {

			System.out.println("Amouth validated.");
		} else {
			System.out.println("Element is Absent");

		}

		// SEND TOP UP
		driver.findElement(By.xpath("//span[text()=\" Send TOP-UP \"]")).click();
		Thread.sleep(5000);

		// PROCESS IS DONE VALIDATION
		if (driver.findElements(By.xpath("//h2[text()=\"Confirm\"]")).size() != 0) {

			Assert.assertTrue(true);
		} else {

			Assert.assertTrue(false);

		}

		Thread.sleep(2000);

	}

}

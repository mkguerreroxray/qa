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
public class MultiservicesNationalMobileTopUpTest extends TestBase {
	@Test
	@Severity(SeverityLevel.CRITICAL)
	public void BE_Multiservices_National_Mobile_Top_Up_Test() throws Exception {

		// LOGIN
		driver.get("https://multiservices-be-cld-ts.moneytrans.eu/auth/login");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='User name (login)']")));
		element.sendKeys("product");
		WebElement elementTwo = driver.findElement(By.xpath(
				"//*[@id=\"login-wrapper\"]/div[2]/form/nz-form-item[2]/nz-form-control/div/span/nz-input-group/input"));
		elementTwo.sendKeys("test");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

		// POP UP
		WebElement elementThree = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//*[@class=\"product-display-name col-xs-10\"])[3]")));
		elementThree.click();
		WebElement elementFour = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//*[@id=\"main-wrapper\"]/app-root/ng-component/div/div/mt-nmt-sale/div[2]/div[1]/div/form/div[1]/div/div[2]/lib-mt-big-select-card[9]")));
		elementFour.click();
		driver.findElement(By.xpath("//p[text()='Total: 5,00 EUR']")).click();
		driver.findElement(By.xpath(".//*[text()=' Continue ']")).click();
		driver.findElement(By.xpath("//span[text()=' Send TOP-UP ']")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//span[text()=\"Operation done\"]"))));

		Assert.assertEquals(driver.findElement(By.xpath(".//span[text()=\"Operation done\"]")).isDisplayed(), true);

	}

}

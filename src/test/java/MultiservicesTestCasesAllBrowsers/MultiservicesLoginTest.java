package MultiservicesTestCasesAllBrowsers;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import MultiservicesObjectRepository.HomePage;
import MultiservicesObjectRepository.TestBase;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class MultiservicesLoginTest extends TestBase {

	@Test
	@Severity(SeverityLevel.CRITICAL)
	public void LoginFunctionMultiservices() {

		HomePage Home = new HomePage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(ExpectedConditions.elementToBeClickable(Home.getUserName()));
		Home.getUserName().sendKeys("product");

		wait.until(ExpectedConditions.elementToBeClickable(Home.getPassword()));
		Home.getPassword().sendKeys("test");

		wait.until(ExpectedConditions.elementToBeClickable(Home.getEnter()));
		Home.getEnter().click();
	}

	@Test
	@Severity(SeverityLevel.CRITICAL)
	public void LoginVerifyMultiservices() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		HomePage Home = new HomePage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(Home.getLoginVerify()));

		Assert.assertTrue(Home.getLoginVerify().isDisplayed());

	}

}

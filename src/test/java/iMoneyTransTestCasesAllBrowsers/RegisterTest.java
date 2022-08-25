package iMoneyTransTestCasesAllBrowsers;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import AllureListener.AllureListenerIMoneyTrans;
import Methods.randomMailGenerator;
import Methods.randomNumberGenarator;
import iMoneyTransObjectRepository.RegisterPage;
import iMoneyTransObjectRepository.TestBase;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Listeners({AllureListenerIMoneyTrans.class})
public class RegisterTest extends TestBase {

	@Test
	@Severity(SeverityLevel.CRITICAL)
	public void RegisterTesting() throws InterruptedException {

		RegisterPage RPage = new RegisterPage(driver);
		randomMailGenerator RndmMail = new randomMailGenerator();

		String Email = (RndmMail.getSaltString() + "@gmail.com");

		RPage.RegisterButton().click();

		RPage.Email().sendKeys(Email);

		RPage.ConfirmEmail().sendKeys(Email);

		RPage.CreateAccountButton().click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

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

		RPage.Phone().sendKeys("+32" + RndmNmb.createRandomNumber(8));

		RPage.Password().sendKeys(RndmMail.getSaltString());

		RPage.JoinNow().click();

		Assert.assertEquals(RPage.HeaderValid().isDisplayed(), true);

	}
}

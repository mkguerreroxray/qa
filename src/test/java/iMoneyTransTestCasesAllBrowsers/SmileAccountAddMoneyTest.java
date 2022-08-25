package iMoneyTransTestCasesAllBrowsers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import AllureListener.AllureListenerIMoneyTrans;
import Methods.DropDownSelection;
import Methods.ExplicitWaits;
import iMoneyTransObjectRepository.MobileTopUpPage;
import iMoneyTransObjectRepository.SmileAccountPage;
import iMoneyTransObjectRepository.TestBase;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Listeners({ AllureListenerIMoneyTrans.class })
public class SmileAccountAddMoneyTest extends TestBase {

	@Test(priority = 0)
	@Severity(SeverityLevel.CRITICAL)
	public void SmileAccountAddMoneyTesting() throws InterruptedException {

		LoginTest LogTest = PageFactory.initElements(driver, LoginTest.class);
		LogTest.Login();

		SmileAccountPage SAPage = new SmileAccountPage(driver);

		ExplicitWaits.ElementClickVerify(SAPage.SmileAccountMastercardButton());
		SAPage.SmileAccountMastercardButton().click();

		SAPage.AddMoneyButton().click();
		Thread.sleep(5000);

		SAPage.AddMoneyBox().sendKeys("10");
		Thread.sleep(5000);

		SAPage.PayNowButton().click();

	}

	@Test(priority = 1)
	@Severity(SeverityLevel.CRITICAL)
	public void WorldLinePayment() throws InterruptedException {

		WebElement CardNumberField = driver.findElement(By.xpath("//input[@id=\"cardNumberField\"]"));
		ExplicitWaits.ElementClickVerify(CardNumberField);
		CardNumberField.sendKeys("5017670000000000");

		MobileTopUpPage MTUPage = new MobileTopUpPage(driver);

		DropDownSelection DDSelect = new DropDownSelection();
		WebElement ExpiryDate = driver.findElement(By.xpath("//select[@id='expirydatefield-year']"));
		DDSelect.DropdownListSelect(ExpiryDate, "2024");

		MTUPage.SecurityCode().sendKeys("436");

		MTUPage.ConfirmButton().click();

		MTUPage.SubmitButton().click();
		Thread.sleep(5000);

		Assert.assertEquals(MTUPage.PaymentConfirmation().isDisplayed(), true);

	}

}

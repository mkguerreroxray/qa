package iMoneyTransTestCasesAllBrowsers;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import AllureListener.AllureListenerIMoneyTrans;
import iMoneyTransObjectRepository.SmileAccountPage;
import iMoneyTransObjectRepository.TestBase;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Listeners({AllureListenerIMoneyTrans.class})
public class RepeatTransactionOnSmileAccountTest extends TestBase {

	@Test
	@Severity(SeverityLevel.CRITICAL)
	public void RepeatTransactionOnSmileAccountTesting() throws InterruptedException {

		LoginTest LogTest = PageFactory.initElements(driver, LoginTest.class);
		LogTest.Login();

		SmileAccountPage SAPage = new SmileAccountPage(driver);
		SAPage.SmileAccountMastercardButton().click();

		SAPage.HistoryTab().click();
		Thread.sleep(5000);

		SAPage.Search().sendKeys("Deposit");

		SAPage.DetailsDeposit().click();

		SAPage.RepeatTransaction().click();
		Thread.sleep(8000);

		SAPage.PayNowButton().click();

		SmileAccountAddMoneyTest SAAMTest = new SmileAccountAddMoneyTest();

		SAAMTest.WorldLinePayment();

	}

}

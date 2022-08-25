package iMoneyTransTestCasesAllBrowsers;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import AllureListener.AllureListenerIMoneyTrans;
import iMoneyTransObjectRepository.MoneyTransferSendMoneyPage;
import iMoneyTransObjectRepository.TestBase;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Listeners({AllureListenerIMoneyTrans.class})
public class MoneyTransferSendMoneyWithCashPickupTest extends TestBase {

	@Test
	@Severity(SeverityLevel.CRITICAL)
	public void MoneyTransferSendMoneyWithBankDepositTesting() throws InterruptedException {

		LoginTest LogTest = PageFactory.initElements(driver, LoginTest.class);
		LogTest.Login();

		MoneyTransferSendMoneyPage MTSendMoneyPage = new MoneyTransferSendMoneyPage(driver);

		MTSendMoneyPage.MoneyTransferButton().click();
		MTSendMoneyPage.SendMoneyButton().click();
		Thread.sleep(7000);

		Actions actions = new Actions(driver);
		actions.moveToElement(MTSendMoneyPage.SelectDestinationCountry()).click().build().perform();
		Thread.sleep(1000);
		MTSendMoneyPage.SelectDestinationCountryResult().click();

		MTSendMoneyPage.CashPickup().click();
		Thread.sleep(4000);

		actions.moveToElement(MTSendMoneyPage.SelectCity()).click().build().perform();
		Thread.sleep(1000);
		MTSendMoneyPage.SelectCityResult().click();
		Thread.sleep(4000);

		actions.moveToElement(MTSendMoneyPage.NextStep()).click().build().perform();

		MTSendMoneyPage.SelectRecipient().click();
		Thread.sleep(4000);

		actions.moveToElement(MTSendMoneyPage.NextStep()).click().build().perform();

		actions.moveToElement(MTSendMoneyPage.SelectSendingReason()).click().build().perform();
		Thread.sleep(1000);
		MTSendMoneyPage.SelectSendingReasonResult().click();

		actions.moveToElement(MTSendMoneyPage.SelectSourceofFunds()).click().build().perform();
		Thread.sleep(1000);
		MTSendMoneyPage.SelectSourceofFundsResult().click();
		Thread.sleep(4000);

		actions.moveToElement(MTSendMoneyPage.NextStep()).click().build().perform();

		MTSendMoneyPage.SelectPaymentMethod().click();
		Thread.sleep(3000);

		MTSendMoneyPage.YouSend().sendKeys("10");
		Thread.sleep(4000);

		actions.moveToElement(MTSendMoneyPage.NextStep()).click().build().perform();

		MTSendMoneyPage.Send().click();

		SmileAccountAddMoneyTest SAAMTest = new SmileAccountAddMoneyTest();

		SAAMTest.WorldLinePayment();

	}
}

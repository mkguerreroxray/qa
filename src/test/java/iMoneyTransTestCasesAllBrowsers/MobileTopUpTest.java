package iMoneyTransTestCasesAllBrowsers;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import AllureListener.AllureListenerIMoneyTrans;
import iMoneyTransObjectRepository.MobileTopUpPage;
import iMoneyTransObjectRepository.MoneyTransferSendMoneyPage;
import iMoneyTransObjectRepository.TestBase;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Listeners({AllureListenerIMoneyTrans.class})
public class MobileTopUpTest extends TestBase {

	@Test
	@Severity(SeverityLevel.CRITICAL)
	public void MobileTopUpTesting() throws InterruptedException {

		LoginTest LogTest = PageFactory.initElements(driver, LoginTest.class);
		LogTest.Login();

		MobileTopUpPage MTUPage = new MobileTopUpPage(driver);

		MTUPage.MobileTopUpButton().click();

		MTUPage.SendTopUpButton().click();

		MTUPage.SelectRecipient().click();
		Thread.sleep(8000);

		MoneyTransferSendMoneyPage MTSMPage = new MoneyTransferSendMoneyPage(driver);

		Actions actions = new Actions(driver);

		actions.moveToElement(MTSMPage.NextStep()).click().build().perform();
		Thread.sleep(4000);

		MTUPage.Amount().click();

		MTUPage.SelectPaymentMethod().click();

		actions.moveToElement(MTSMPage.NextStep()).click().build().perform();
		Thread.sleep(3000);

		actions.moveToElement(MTUPage.SendTopUpButton()).click().build().perform();
		Thread.sleep(2000);

		SmileAccountAddMoneyTest SAAMTest = new SmileAccountAddMoneyTest();
		SAAMTest.WorldLinePayment();

	}

}

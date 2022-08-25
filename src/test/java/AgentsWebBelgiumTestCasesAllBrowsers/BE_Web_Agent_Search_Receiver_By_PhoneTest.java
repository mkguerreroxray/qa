package AgentsWebBelgiumTestCasesAllBrowsers;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import AgentsWebObjectRepository.LoginPage;
import AgentsWebObjectRepository.ReceiverModulePage;
import AgentsWebObjectRepository.SenderModulePage;
import AgentsWebObjectRepository.TestBase;
import AllureListener.AllureListenerAgentsWeb;
import Methods.SwitchToWindow;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Listeners({ AllureListenerAgentsWeb.class })
public class BE_Web_Agent_Search_Receiver_By_PhoneTest extends TestBase {

	@Test
	@Severity(SeverityLevel.MINOR)
	public void BE_Web_Agent_Search_Receiver_By_Phone_Test() throws InterruptedException {

		driver.get("https://agents-pre-be.moneytrans.eu/Login.aspx");

		// LOGIN
		LoginPage LP = new LoginPage(driver);
		LP.LogInFunction();
		LP.NewTransfer().click();
		Thread.sleep(4000);

		SwitchToWindow SwitchWindow = new SwitchToWindow();
		SwitchWindow.SwitchToNewFirstWindowMethod(driver);

		// RECEIVER MODULE
		SenderModulePage SenderModule = new SenderModulePage(driver);
		SenderModule.getNextButton().click();

		// EXISTENT CUSTOMER SELECTION
		ReceiverModulePage ReceiverModule = new ReceiverModulePage(driver);
		ReceiverModule.getExistentReceiverSelectionByPhone().click();
		ReceiverModule.getGetExistentReceiverTxtSearch().sendKeys("+322015550123");
		ReceiverModule.getGetReceiverSearchButton().click();
		Thread.sleep(5000);

		// TEST USER SELECTION
		ReceiverModule.getTestUserSelectionReceiver().click();
		Thread.sleep(2000);

		// ACCEPT BUTTON
		ReceiverModule.getAcceptButtonReceiver().click();
		Thread.sleep(5000);

		// GET PHONE
		String phone = ReceiverModule.getPhoneReceiver().getAttribute("value");

		// CONTROL
		String ActualPhone = "+322015550123";

		Assert.assertEquals(ActualPhone, phone);

	}

}

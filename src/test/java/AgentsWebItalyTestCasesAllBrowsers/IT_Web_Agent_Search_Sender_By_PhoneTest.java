package AgentsWebItalyTestCasesAllBrowsers;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import AgentsWebObjectRepository.LoginPage;
import AgentsWebObjectRepository.SenderModulePage;
import AgentsWebObjectRepository.TestBase;
import AllureListener.AllureListenerAgentsWeb;
import Methods.SwitchToWindow;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Listeners({ AllureListenerAgentsWeb.class })
public class IT_Web_Agent_Search_Sender_By_PhoneTest extends TestBase {

	@Test
	@Severity(SeverityLevel.MINOR)
	public void BE_Web_Agent_Search_Sender_By_Phone_Test() throws InterruptedException {

		driver.get("https://agents-pre-it.moneytrans.eu/Login.aspx");

		// LOGIN
		LoginPage LP = new LoginPage(driver);
		LP.LogInFunction();
		LP.NewTransfer().click();
		Thread.sleep(4000);

		SwitchToWindow SwitchWindow = new SwitchToWindow();
		SwitchWindow.SwitchToNewFirstWindowMethod(driver);

		// SENDER MODULE

		// EXISTENT CUSTOMER SELECTION
		SenderModulePage SenderModule = new SenderModulePage(driver);
		SenderModule.getExistentCustomerSelectionByPhone().click();
		SenderModule.getExistentCustomerTxtSearch().sendKeys("+3255555555");
		SenderModule.getExistentCustomerSearchButton().click();
		Thread.sleep(5000);

		// TEST USER SELECTION
		SenderModule.getTestUserSelection().click();
		Thread.sleep(2000);

		// ACCEPT BUTTON
		SenderModule.getAcceptButton().click();
		Thread.sleep(5000);

		// GET PHONE
		String phone = SenderModule.getPhone().getAttribute("value");

		// CONTROL
		String ActualPhone = "+3255555555";

		Assert.assertEquals(ActualPhone, phone);

	}

}

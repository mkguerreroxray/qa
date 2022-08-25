package AgentsWebBelgiumRegressionTestSuite;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import AgentsWebModules.DestinationAmountsModuleBelgium;
import AgentsWebModules.ReceiverModuleBelgium;
import AgentsWebModules.SenderModuleBelgium;
import AgentsWebObjectRepository.DestinationAmountsModulePage;
import AgentsWebObjectRepository.LoginPage;
import AgentsWebObjectRepository.TestBase;
import AllureListener.AllureListenerAgentsWeb;
import Methods.SwitchToWindow;
import Methods.randomMailGenerator;
import Methods.randomNumberGenarator;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Listeners({ AllureListenerAgentsWeb.class })
public class BE_Web_Agent_Money_Transfer_with_New_Sender_New_ReceiverTest extends TestBase {

	randomNumberGenarator RndmNmb = new randomNumberGenarator();
	randomMailGenerator RndmMail = new randomMailGenerator();

	@Test
	@Severity(SeverityLevel.CRITICAL)
	public void BE_Web_Agent_Money_Transfer_with_New_Customer_Test() throws Exception {

		driver.get("https://agents-pre-be.moneytrans.eu/Login.aspx");

		LoginPage LP = new LoginPage(driver);
		LP.LogInFunction();
		LP.NewTransfer().click();
		Thread.sleep(4000);

		SwitchToWindow SwitchWindow = new SwitchToWindow();
		SwitchWindow.SwitchToNewFirstWindowMethod(driver);

		// SENDER MODULE
		SenderModuleBelgium SenderModuleBelgiumTest = new SenderModuleBelgium();
		SenderModuleBelgiumTest.SenderModuleBelgiumTest();

		// RECEIVER MODULE
		ReceiverModuleBelgium ReceiverModuleBelgiumTest = new ReceiverModuleBelgium();
		ReceiverModuleBelgiumTest.ReceiverModuleBelgiumTest();

		// DESTINATION & AMOUNTS MODULE
		DestinationAmountsModuleBelgium DestinationAmountsModuleBelgiumTest = new DestinationAmountsModuleBelgium();
		DestinationAmountsModuleBelgiumTest.DestinationAmountsModuleBelgiumTest();

		SwitchWindow.SwitchBackToParentWindowMethod(driver);

		// TRANSFERS SCREEN
		DestinationAmountsModulePage DestinationModule = new DestinationAmountsModulePage(driver);
		DestinationModule.getTransfers().click();
		DestinationModule.getTransfersList().click();
		DestinationModule.getSearchButton().click();

		String Control = DestinationModule.getControl().getText();
		String Control_1 = "Belgium";
		System.out.println(Control);
		System.out.println(Control_1);

		Assert.assertEquals(Control, Control_1);
	}

}

package AgentsWebItalyRegressionTestSuite;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import AgentsWebModules.DestinationsAmounthsModuleItaly;
import AgentsWebModules.ReceiverModuleItaly;
import AgentsWebModules.SenderModuleItaly;
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
public class IT_Web_Agent_Money_Transfer_with_New_Sender_New_ReceiverTest extends TestBase {

	randomNumberGenarator RndmNmb = new randomNumberGenarator();
	randomMailGenerator RndmMail = new randomMailGenerator();

	@Test
	@Severity(SeverityLevel.CRITICAL)
	public void IT_Web_Agent_Money_Transfer_with_New_Customer_Test() throws Exception {

		driver.get("https://agents-pre-it.moneytrans.eu/Login.aspx");

		LoginPage LP = new LoginPage(driver);
		LP.LogInFunction();
		LP.NewTransfer().click();
		Thread.sleep(4000);
		
		SwitchToWindow SwitchWindow = new SwitchToWindow();
		SwitchWindow.SwitchToNewFirstWindowMethod(driver);

		// SENDER MODULE

		SenderModuleItaly SenderModuleItalyTest = new SenderModuleItaly();
		SenderModuleItalyTest.SenderModuleItalyTest();

		// RECEIVER MODULE

		ReceiverModuleItaly ReceiverModuleItalyTest = new ReceiverModuleItaly();
		ReceiverModuleItalyTest.ReceiverModuleItalyTest();

		// DESTINATION & AMOUNTS MODULE

		DestinationsAmounthsModuleItaly DestinationsAmounthsModuleItalyTest = new DestinationsAmounthsModuleItaly();
		DestinationsAmounthsModuleItalyTest.DestinationsAmounthsModuleItalyTest();

		SwitchWindow.SwitchBackToParentWindowMethod(driver);

		// TRANSFERS SCREEN
		DestinationAmountsModulePage DestinationModule = new DestinationAmountsModulePage(driver);
		DestinationModule.getTransfers().click();
		DestinationModule.getTransfersList().click();
		DestinationModule.getSearchButton().click();

		String Control = DestinationModule.getControl().getText();
		String Control_1 = "ITALIA";
		System.out.println(Control);
		System.out.println(Control_1);

		Assert.assertEquals(Control, Control_1);

	}

}

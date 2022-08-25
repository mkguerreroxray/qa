package AgentsWebSpainRegressionTestSuite;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import AgentsWebModules.DestinationsAmounthsModuleSpain;
import AgentsWebModules.ReceiverModuleSpain;
import AgentsWebModules.SenderModuleSpain;
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
public class ES_Web_Agent_Money_Transfer_with_New_Sender_Transfer_Add_NotesTest extends TestBase {

	randomNumberGenarator RndmNmb = new randomNumberGenarator();
	randomMailGenerator RndmMail = new randomMailGenerator();

	@Test
	@Severity(SeverityLevel.MINOR)
	public void ES_Web_Agent_Money_Transfer_with_New_Customer_Transfer_Cancel_Immediately() throws Exception {
		// TODO Auto-generated method stub

		driver.get("https://agents-pre-es.moneytrans.eu/Login.aspx");

		// LOGIN
		LoginPage LP = new LoginPage(driver);
		LP.LogInFunction();
		LP.NewTransfer().click();
		Thread.sleep(4000);

		// SWITCH TO WINDOW
		SwitchToWindow SwitchWindow = new SwitchToWindow();
		SwitchWindow.SwitchToNewFirstWindowMethod(driver);

		// SENDER MODULE

		SenderModuleSpain SenderModuleSpainTest = new SenderModuleSpain();
		SenderModuleSpainTest.SenderModuleSpainTest();

		// RECEIVER MODULE

		ReceiverModuleSpain ReceiverModuleSpainTest = new ReceiverModuleSpain();
		ReceiverModuleSpainTest.ReceiverModuleSpainTest();

		// DESTINATION & AMOUNTS MODULE

		DestinationsAmounthsModuleSpain DestinationsAmounthsModuleSpainTest = new DestinationsAmounthsModuleSpain();
		DestinationsAmounthsModuleSpainTest.DestinationsAmounthsModuleSpainTest();
		SwitchWindow.SwitchBackToParentWindowMethod(driver);

		// TRANSFERS SCREEN
		DestinationAmountsModulePage DestinationModule = new DestinationAmountsModulePage(driver);
		DestinationModule.getTransfers().click();
		DestinationModule.getTransfersList().click();
		DestinationModule.getSearchButton().click();
		DestinationModule.getViewDetailsButton().click();

		// SWITCH TO WINDOW
		SwitchWindow.SwitchToNewFirstWindowMethod(driver);

		// Notes Button
		DestinationModule.getNotesButton().click();

		// Add Note
		DestinationModule.getAddNotesButton().click();
		DestinationModule.getNotesText().clear();
		DestinationModule.getNotesText().sendKeys("Automation");
		DestinationModule.getSaveChangesButton().click();

		// VALIDATE IF NOTE VISIBLE
		Assert.assertEquals(DestinationModule.getValidateIfNoteVisible().isDisplayed(), true);

	}

}

package AgentsWebSpainRegressionTestSuite;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import AgentsWebModules.DestinationsAmounthsModuleSpain;
import AgentsWebModules.ReceiverModuleSpain;
import AgentsWebObjectRepository.DestinationAmountsModulePage;
import AgentsWebObjectRepository.LoginPage;
import AgentsWebObjectRepository.SenderModulePage;
import AgentsWebObjectRepository.TestBase;
import AllureListener.AllureListenerAgentsWeb;
import Methods.DropDownSelection;
import Methods.SwitchToWindow;
import Methods.randomMailGenerator;
import Methods.randomNumberGenarator;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Listeners({ AllureListenerAgentsWeb.class })
public class ES_Web_Agent_Money_Transfer_with_Existent_SenderTest extends TestBase {

	randomNumberGenarator RndmNmb = new randomNumberGenarator();
	randomMailGenerator RndmMail = new randomMailGenerator();

	@Test
	@Severity(SeverityLevel.CRITICAL)
	public void ES_Web_Agent_Money_Transfer_with_Existent_Customer_Test() throws Exception {
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

		// EXISTENT CUSTOMER SELECTION
		SenderModulePage SenderModule = new SenderModulePage(driver);
		SenderModule.getExistentCustomerSelectionByName().click();
		SenderModule.getExistentCustomerTxtSearch().sendKeys("automation");
		SenderModule.getExistentCustomerSearchButton().click();
		Thread.sleep(5000);

		// TEST USER SELECTION
		SenderModule.getTestUserSelection().click();
		Thread.sleep(2000);

		// ACCEPT BUTTON
		SenderModule.getAcceptButton().click();
		Thread.sleep(5000);

		// EDIT BUTTON
		SenderModule.getEditButton().click();
		Thread.sleep(4000);

		DropDownSelection DropDownSelect = new DropDownSelection();

		// SOURCE OF FUNDS
		DropDownSelect.DropdownListSelect(SenderModule.getSourceOfFunds(), "Gift");

		// PURPOSE OF TRANSACTION
		DropDownSelect.DropdownListSelect(SenderModule.getPurposeOfTransaction(), "Gift");

		// NEXT BUTTON
		SenderModule.getNextButton().click();

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

		String Control = DestinationModule.getControl().getText();
		String Control_1 = "Polonia";
		System.out.println(Control);
		System.out.println(Control_1);

		Assert.assertEquals(Control, Control_1);

	}
}

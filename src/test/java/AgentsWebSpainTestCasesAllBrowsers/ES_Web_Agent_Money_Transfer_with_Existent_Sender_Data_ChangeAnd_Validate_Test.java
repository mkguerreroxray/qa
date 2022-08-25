package AgentsWebSpainTestCasesAllBrowsers;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import AgentsWebModules.DestinationsAmounthsModuleSpain;
import AgentsWebModules.ReceiverModuleSpain;
import AgentsWebObjectRepository.DestinationAmountsModulePage;
import AgentsWebObjectRepository.LoginPage;
import AgentsWebObjectRepository.ReceiverModulePage;
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
public class ES_Web_Agent_Money_Transfer_with_Existent_Sender_Data_ChangeAnd_Validate_Test extends TestBase {

	randomNumberGenarator RndmNmb = new randomNumberGenarator();
	randomMailGenerator RndmMail = new randomMailGenerator();

	@Test
	@Severity(SeverityLevel.NORMAL)
	public void ES_Web_Agent_Money_Transfer_with_Existent_Customer() throws Exception {
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

		// CHILD WINDOW OPERATIONS HERE

		////////////////////////////// SENDER MODULE //////////////////////////////////

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
		DestinationModule.getViewDetailsButton().click();

		// SWITCH TO TRANSFERS DETAIL WINDOW
		SwitchWindow.SwitchToNewFirstWindowMethod(driver);
		ReceiverModulePage ReceiverModule = new ReceiverModulePage(driver);
		String Control = driver.findElement(By.id("txtReceiverTelep")).getAttribute("value");
		System.out.println(Control);
		System.out.println(ReceiverModule.getPhone());
		Assert.assertEquals(Control, "+49" + ReceiverModule.getPhone());

	}
}

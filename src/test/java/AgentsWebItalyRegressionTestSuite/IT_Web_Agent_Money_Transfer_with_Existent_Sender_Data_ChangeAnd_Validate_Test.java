package AgentsWebItalyRegressionTestSuite;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import AgentsWebModules.DestinationsAmounthsModuleItaly;
import AgentsWebModules.ReceiverModuleItaly;
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
public class IT_Web_Agent_Money_Transfer_with_Existent_Sender_Data_ChangeAnd_Validate_Test extends TestBase {

	randomNumberGenarator RndmNmb = new randomNumberGenarator();
	randomMailGenerator RndmMail = new randomMailGenerator();

	@Test(enabled = false)
	@Severity(SeverityLevel.NORMAL)
	public void IT_Web_Agent_Money_Transfer_with_Existent_Customer() throws Exception {
		// TODO Auto-generated method stub

		driver.get("https://agents-pre-it.moneytrans.eu/Login.aspx");

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

		// CHECK IF FISCAL CODE BOX IS CHECKED
		if (!driver.findElement(By.id("SenderModule_chkNoFiscalCode")).isSelected()) {
			driver.findElement(By.id("SenderModule_chkNoFiscalCode")).click();
		}

		DropDownSelection DropDownSelect = new DropDownSelection();

		// SOURCE OF FUNDS
		DropDownSelect.DropdownListSelect(SenderModule.getSourceOfFunds(), "Gift");

		// PURPOSE OF TRANSACTION
		DropDownSelect.DropdownListSelect(SenderModule.getPurposeOfTransaction(), "Gift");

		// SUSPICIOUS BEHAVIOUR
		DropDownSelect.DropdownListSelect(SenderModule.getSuspiciousBehaviour(), "No");

		// NEXT BUTTON
		SenderModule.getNextButton().click();

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

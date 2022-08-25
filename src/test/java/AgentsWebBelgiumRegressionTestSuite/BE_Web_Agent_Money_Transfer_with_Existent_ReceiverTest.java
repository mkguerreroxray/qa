package AgentsWebBelgiumRegressionTestSuite;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import AgentsWebModules.DestinationAmountsModuleBelgium;
import AgentsWebModules.SenderModuleBelgium;
import AgentsWebObjectRepository.DestinationAmountsModulePage;
import AgentsWebObjectRepository.LoginPage;
import AgentsWebObjectRepository.ReceiverModulePage;
import AgentsWebObjectRepository.SenderModulePage;
import AgentsWebObjectRepository.TestBase;
import AllureListener.AllureListenerAgentsWeb;
import Methods.SwitchToWindow;
import Methods.randomMailGenerator;
import Methods.randomNumberGenarator;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Listeners({ AllureListenerAgentsWeb.class })
public class BE_Web_Agent_Money_Transfer_with_Existent_ReceiverTest extends TestBase {

	randomNumberGenarator RndmNmb = new randomNumberGenarator();
	randomMailGenerator RndmMail = new randomMailGenerator();

	@Test
	@Severity(SeverityLevel.CRITICAL)
	public void BE_Web_Agent_Money_Transfer_with_New_Customer() throws Exception {
		// TODO Auto-generated method stub

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30, 1));
		driver.get("https://agents-pre-be.moneytrans.eu/Login.aspx");

		// LOGIN
		LoginPage LP = new LoginPage(driver);
		LP.LogInFunction();
		LP.NewTransfer().click();
		Thread.sleep(4000);

		SwitchToWindow SwitchWindow = new SwitchToWindow();
		SwitchWindow.SwitchToNewFirstWindowMethod(driver);

		// SENDER MODULE
		SenderModuleBelgium SenderModuleBelgiumTest = new SenderModuleBelgium();
		SenderModuleBelgiumTest.SenderModuleBelgiumTest();

		///////////////////////// RECEIVER MODULE ////////////////////////////

		// Existent receiver selection
		ReceiverModulePage ReceiverModule = new ReceiverModulePage(driver);
		ReceiverModule.getExistentReceiver().sendKeys("Automation");

		ReceiverModule.getSearchByReceiverNameButton().click();

		ReceiverModule.getSearchReceiverButton().click();

		// Search button
		ReceiverModule.getSearchReceiver().click();

		// Accept button
		ReceiverModule.getAcceptButton().click();
		Thread.sleep(200);

		// EDIT BUTTON
		ReceiverModule.getEditButton().click();
		Thread.sleep(5000);

		// RELATIONSHIP WITH BENEFICIARY
		wait.until(ExpectedConditions.elementToBeClickable(ReceiverModule.getRelationshipWithBeneficiary()));
		ReceiverModule.getRelationshipWithBeneficiary().click();
		ReceiverModule.getRelationshipWithBeneficiary().sendKeys("Friend");
		Thread.sleep(1000);
		ReceiverModule.getRelationshipWithBeneficiary().sendKeys(Keys.ENTER);

		// NEXT BUTTON
		SenderModulePage SenderModule = new SenderModulePage(driver);
		SenderModule.getNextButton().click();

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

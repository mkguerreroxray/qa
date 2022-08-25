package iMoneyTransTestCasesAllBrowsers;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import AllureListener.AllureListenerIMoneyTrans;
import Methods.randomNumberGenarator;
import iMoneyTransObjectRepository.MobileTopUpPage;
import iMoneyTransObjectRepository.TestBase;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Listeners({AllureListenerIMoneyTrans.class})
public class MobileTopUpAddRecipientTest extends TestBase {

	@Test
	@Severity(SeverityLevel.NORMAL)
	public void MobileTopUpAddingRecipientTest() throws InterruptedException {

		LoginTest LogTest = PageFactory.initElements(driver, LoginTest.class);
		LogTest.Login();

		MobileTopUpPage MTUPage = new MobileTopUpPage(driver);
		randomNumberGenarator RndmNmb = new randomNumberGenarator();

		MTUPage.MobileTopUpButton().click();

		MTUPage.Recipients().click();

		MTUPage.AddRecipient().click();

		MTUPage.FirstName().clear();
		MTUPage.FirstName().sendKeys("Test");

		MTUPage.LastName().clear();
		MTUPage.LastName().sendKeys("Automation");

		MTUPage.Phone().sendKeys("+9054" + RndmNmb.createRandomNumber(8));
		Thread.sleep(6000);

		MTUPage.SaveRecipient().click();
		Thread.sleep(7000);

		MTUPage.Search().sendKeys("Test Automation");
		Thread.sleep(3000);

		Assert.assertEquals(MTUPage.RecipientNameConfirmation().isDisplayed(), true);

	}

}

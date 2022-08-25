package iMoneyTransTestCasesAllBrowsers;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import AllureListener.AllureListenerIMoneyTrans;
import iMoneyTransObjectRepository.MobileTopUpPage;
import iMoneyTransObjectRepository.TestBase;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Listeners({AllureListenerIMoneyTrans.class})
public class MobileTopUpDeleteRecipientTest extends TestBase {

	@Test
	@Severity(SeverityLevel.NORMAL)
	public void MobileTopUpDeletionofRecipientTest() throws InterruptedException {

		LoginTest LogTest = PageFactory.initElements(driver, LoginTest.class);
		LogTest.Login();

		MobileTopUpPage MTUPage = new MobileTopUpPage(driver);

		MTUPage.MobileTopUpButton().click();

		MTUPage.Recipients().click();
		Thread.sleep(7000);

		MTUPage.Search().sendKeys("Test Automation");
		Thread.sleep(5000);

		if (MTUPage.RecipientNameConfirmation().isDisplayed() == true) {

			MTUPage.Edit().click();
			Thread.sleep(2000);

			MTUPage.Delete().click();
			Thread.sleep(2000);

			MTUPage.DeleteConfirm().click();

		}

		Assert.assertEquals(MTUPage.DeleteConfirmMessage().isDisplayed(), true);

	}

}

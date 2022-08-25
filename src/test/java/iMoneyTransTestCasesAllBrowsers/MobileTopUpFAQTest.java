package iMoneyTransTestCasesAllBrowsers;

import org.openqa.selenium.By;
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
public class MobileTopUpFAQTest extends TestBase {

	private String[] ActualQuestionArray = {

			" 1. What is top up? ", " 2. What can I do with the iMoneytrans Top-up service? ",
			" 3. What countries does iMoneytrans Top-Up serve? ", " 4. Can I send top-up/credit to any phone number? ",
			" 5. What will happen if I try to top-up a phone number that is not supported? ",
			" 6. How much credit can I send? ", " 7. Is there a limit on the credit I can send? ",
			" 8. How can I know if the credit has been received by my contact? ",
			" 9. I received a confirmation SMS, but my contact says s/he hasn’t received the credit. ",
			" 10. How much time does it take for the credit to show up on my contact's account? ",
			" 11. I sent credit to a wrong number by mistake, can I cancel the transaction? ",
			" 12. Do I have to create an account to use this service? ",
			" 13. What information do I need to provide to create this account? ",
			" 14. What are the different means of payment available? "

	};

	@Test
	@Severity(SeverityLevel.TRIVIAL)
	public void MobileTopUPFAQTesting() throws InterruptedException {

		LoginTest LogTest = PageFactory.initElements(driver, LoginTest.class);
		LogTest.Login();

		MobileTopUpPage MTUPage = new MobileTopUpPage(driver);

		MTUPage.MobileTopUpButton().click();

		MTUPage.FAQTab().click();

		String[] QuestionList = new String[15];

		for (int i = 1; i < QuestionList.length; i++) {

			QuestionList[i] = driver
					.findElement(By.xpath("(//button[@class=\"btn btn-link ng-star-inserted\"])[" + i + "]"))
					.getAttribute("innerHTML");

			String Actual = QuestionList[i];
			String Expected = ActualQuestionArray[i - 1];

			System.out.println(Actual);
			System.out.println(Expected);

			Assert.assertEquals(Actual, Expected);

		}

	}

}

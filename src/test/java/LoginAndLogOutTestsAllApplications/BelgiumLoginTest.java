package LoginAndLogOutTestsAllApplications;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import AgentsWebObjectRepository.LoginPage;
import AgentsWebObjectRepository.TestBase;
import AllureListener.AllureListenerAgentsWeb;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Listeners({ AllureListenerAgentsWeb.class })
public class BelgiumLoginTest extends TestBase {

	@Test
	@Severity(SeverityLevel.CRITICAL)
	public void LoginFuncTest() {

		driver.get("https://agents-pre-be.moneytrans.eu/Login.aspx");

		LoginPage LP = new LoginPage(driver);
		LP.LogInFunction();

		Assert.assertTrue(driver.findElement(By.xpath("(//a[text()='New Transfer'])[2]")).isDisplayed());

	}

}

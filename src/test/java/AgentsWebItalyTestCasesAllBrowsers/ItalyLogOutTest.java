package AgentsWebItalyTestCasesAllBrowsers;

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
public class ItalyLogOutTest extends TestBase {

	@Test
	@Severity(SeverityLevel.CRITICAL)
	public void ItalyLogOutFuncTest() {

		driver.get("https://agents-pre-it.moneytrans.eu/Login.aspx");

		LoginPage LP = new LoginPage(driver);
		LP.LogInFunction();

		driver.findElement(By.xpath("(//div[@class=\"arrow element\"])[1]")).click();

		driver.findElement(By.xpath("//li[text()='Logout']")).click();

		Assert.assertTrue(driver.findElement(By.id("imgLogin")).isDisplayed());

	}

}

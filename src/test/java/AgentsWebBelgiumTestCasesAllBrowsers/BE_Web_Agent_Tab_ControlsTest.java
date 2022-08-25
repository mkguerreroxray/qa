package AgentsWebBelgiumTestCasesAllBrowsers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import AgentsWebObjectRepository.LoginPage;
import AgentsWebObjectRepository.TestBase;
import AllureListener.AllureListenerAgentsWeb;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Listeners({ AllureListenerAgentsWeb.class })
public class BE_Web_Agent_Tab_ControlsTest extends TestBase {

	@Test
	@Severity(SeverityLevel.TRIVIAL)
	public void BE_Web_Agent_Money_Transfer_with_Existent_Customer() throws Exception {
		// TODO Auto-generated method stub

		driver.get("https://agents-pre-be.moneytrans.eu/Login.aspx");

		// LOGIN
		LoginPage LP = new LoginPage(driver);
		LP.LogInFunction();

		// TABS
		for (int i = 1; i < 7; i++) {

			WebElement Tabs = driver
					.findElement(By.xpath("(//div[@class=\"MainMenuWrapper\"]/div/ul/li/a)[" + i + "]"));
			Tabs.click();
			Thread.sleep(300);

		}

	}

}
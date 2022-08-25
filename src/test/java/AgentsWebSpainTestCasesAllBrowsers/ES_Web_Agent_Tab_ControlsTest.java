package AgentsWebSpainTestCasesAllBrowsers;

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
public class ES_Web_Agent_Tab_ControlsTest extends TestBase {

	@Test
	@Severity(SeverityLevel.MINOR)
	public void BE_Web_Agent_Money_Transfer_with_Existent_Customer() throws Exception {

		driver.get("https://agents-pre-es.moneytrans.eu/Login.aspx");

		// LOGIN
		LoginPage LP = new LoginPage(driver);
		LP.LogInFunction();
		Thread.sleep(4000);

		// TABS
		for (int i = 1; i < 7; i++) {

			WebElement Tabs = driver
					.findElement(By.xpath("(//div[@class=\"MainMenuWrapper\"]/div/ul/li/a)[" + i + "]"));
			Tabs.click();
			Thread.sleep(300);

		}

	}

}
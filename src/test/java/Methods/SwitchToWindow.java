package Methods;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import AgentsWebObjectRepository.TestBase;

public class SwitchToWindow extends TestBase {

	@Test
	public void ArrayInitializer(WebDriver driver, int i) {

		ArrayList<String> NewTab = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(NewTab.get(i));
		driver.manage().window().maximize();

	}

	@Test
	public void SwitchToNewFirstWindowMethod(WebDriver driver) {

		ArrayInitializer(driver, 1);

	}

	@Test
	public void SwitchToNewSecondWindowMethod(WebDriver driver) {

		ArrayInitializer(driver, 2);

	}

	@Test
	public void SwitchBackToParentWindowMethod(WebDriver driver) {

		ArrayInitializer(driver, 0);
	}
}

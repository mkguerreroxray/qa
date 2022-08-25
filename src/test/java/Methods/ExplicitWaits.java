package Methods;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ExplicitWaits {

	public static WebDriverWait wait;
	public static WebDriver driver;
	public static int duration;

	@Test
	public void WaitInitializer() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		ExplicitWaits.wait = wait;

	}

	@Test
	public static void ElementClickVerify(WebElement element) {

		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	@Test
	public static void ElementVisibleVerify(WebElement element) {

		wait.until(ExpectedConditions.visibilityOf(element));

	}

}

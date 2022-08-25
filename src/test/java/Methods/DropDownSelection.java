package Methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownSelection {

	WebDriver driver;

	public void DropdownListSelect(WebElement E, String X) throws InterruptedException {

		Select Dropdown = new Select(E);
		Dropdown.selectByVisibleText(X);

	}

}

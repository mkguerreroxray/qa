package Methods;

import java.util.List;

import org.openqa.selenium.WebElement;

import AgentsWebObjectRepository.TestBase;

public class DropdownULLITypeSelection extends TestBase {
	

	public void DropdownULLITypeSelect(String optionName, WebElement listbuttonlocator, List<WebElement> listlocator) throws InterruptedException {

		listbuttonlocator.click();
		
		List<WebElement> Cities = listlocator;
		
		for(WebElement city : Cities) {
			
			if(city.getText().equals(optionName)) {
				
				city.click();
				return;
			}
		}

	}

}

package pages;

import configurations.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoQAPage extends BasePage {

	@FindBy(xpath = "//div[contains(@class, 'card')]//h5[contains(text(), 'lements')]")
	private WebElement elementsPage;


    public WebElement getElementsPage() {
        return elementsPage;
    }
}

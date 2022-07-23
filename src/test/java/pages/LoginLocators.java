package pages;

import configurations.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginLocators extends BasePage {

	@FindBy(xpath = "//*[@id=\"jot-ui-searchInput\"]")
	private WebElement username;

    public WebElement getUsername() {
        return username;
    }

}

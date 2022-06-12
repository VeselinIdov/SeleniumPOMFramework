package configurations;

import org.openqa.selenium.support.PageFactory;

abstract public class BasePage {

    public BasePage() {
        PageFactory.initElements(BaseTest.driver, this);
    }
}
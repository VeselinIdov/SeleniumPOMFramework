package configurations;

import utils.WaitUtility;
import utils.WebUtility;

public class BasePage {

    protected WaitUtility waitUtility;
    protected WebUtility webUtility;

    public BasePage() {
        this.waitUtility = new WaitUtility(WebDriverFactory.getDriver());
        this.webUtility = new WebUtility(WebDriverFactory.getDriver());
    }
}
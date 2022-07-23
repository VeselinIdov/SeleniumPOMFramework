package configurations;

import utils.WaitUtility;
import utils.WebUtility;

public class BasePage {
    protected WaitUtility waitUtility;
    protected WebUtility webUtility;

    public BasePage() {
        this.waitUtility = new WaitUtility(BaseTest.driver);
        this.webUtility = new WebUtility(BaseTest.driver);
    }
}
package configurations;

import org.testng.Assert;
import utils.WaitUtility;
import utils.WebUtility;

public abstract class BasePage {

    protected WaitUtility waitUtility;
    protected WebUtility webUtility;

    public BasePage(String expectedURL) {
        this.waitUtility = new WaitUtility(WebDriverFactory.getDriver());
        this.webUtility = new WebUtility(WebDriverFactory.getDriver(), waitUtility);
        onPage(expectedURL);
    }

    private void onPage(String expectedURL) {
        String currentURL = WebDriverFactory.getDriver().getCurrentUrl();
        Assert.assertTrue(currentURL.contains(expectedURL),
                "Current URL is: " + currentURL + " Expected URL is: " + expectedURL + "");
    }
}
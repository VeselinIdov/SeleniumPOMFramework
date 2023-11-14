package web.pages;

import core.utils.LogUtils;
import org.testng.Assert;
import web.utils.WaitUtility;
import web.utils.WebDriverFactory;
import web.utils.WebUtility;

public abstract class BasePage {

    protected WaitUtility waitUtility;
    protected WebUtility webUtility;

    public BasePage(String expectedURL) {
        this.waitUtility = new WaitUtility(WebDriverFactory.getDriver());
        this.webUtility = new WebUtility(WebDriverFactory.getDriver(), waitUtility);
        LogUtils.LOGGER.info("Validating page with expected URL: " + expectedURL);
        onPage(expectedURL);
    }

    private void onPage(String expectedURL) {
        String currentURL = WebDriverFactory.getDriver().getCurrentUrl();
        Assert.assertTrue(currentURL.contains(expectedURL),
                "Current URL is: " + currentURL + " Expected URL is: " + expectedURL);
    }
}
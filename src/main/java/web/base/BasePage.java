package web.base;

import core.utils.LogUtils;
import org.testng.Assert;
import web.decorator.BaseWebActions;
import web.decorator.LoggingWebActionsDecorator;
import web.utils.WaitUtility;
import web.utils.WebDriverFactory;

public abstract class BasePage {

    protected WaitUtility waitUtility;
    protected LoggingWebActionsDecorator loggingWebActionsDecorator;

    public BasePage(String expectedURL) {
        this();
        LogUtils.LOGGER.info("Validating page with expected URL: " + expectedURL);
        onPage(expectedURL);
    }

    public BasePage() {
        this.waitUtility = new WaitUtility(WebDriverFactory.getDriver());
        this.loggingWebActionsDecorator = new LoggingWebActionsDecorator(new BaseWebActions(WebDriverFactory.getDriver(), waitUtility));
    }

    private void onPage(String expectedURL) {
        String currentURL = WebDriverFactory.getDriver().getCurrentUrl();
        Assert.assertTrue(currentURL.contains(expectedURL),
                "Current URL is: " + currentURL + " Expected URL is: " + expectedURL);
    }
}
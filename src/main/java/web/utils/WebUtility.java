package web.utils;

import core.utils.LogUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class WebUtility {

    private final WebDriver driver;
    private final WaitUtility waitUtility;

    public WebUtility(WebDriver driver, WaitUtility waitUtility) {
        this.driver = driver;
        this.waitUtility = waitUtility;
    }

    public void clickElement(By elementBy) {
        LogUtils.LOGGER.info("Clicking on element with name: " + elementBy);
        waitUtility.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(elementBy)).click();
    }

    public void enterText(By elementBy, String text) {
        LogUtils.LOGGER.info("Entering value in field: " +text);
        getElementLocator(elementBy).sendKeys(Keys.chord(Keys.CONTROL, "a"), text);
    }

    public WebElement getElementLocator(By elementBy) {
        LogUtils.LOGGER.info("Getting element locator with value: " + elementBy);
        return driver.findElement(elementBy);
    }

    public List<WebElement> getAllElements(By elementBy) {
        return driver.findElements(elementBy);
    }

    public String getElementText(By locator) {
        return getElementLocator(locator).getText();
    }

    public void scrollToElementView(By by) {
        WebElement elementToScroll = driver.findElement(by);
        LogUtils.LOGGER.info("Scrolling to element: " + elementToScroll);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elementToScroll);
    }
}
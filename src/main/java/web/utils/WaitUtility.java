package web.utils;

import core.utils.LogUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtility {

    private WebDriverWait webDriverWait;
    private WebDriver driver;

    public WaitUtility(WebDriver driver) {
        this.driver = driver;
    }

    private void setWebDriverWait(int seconds) {
        this.webDriverWait = new WebDriverWait(this.driver, Duration.ofSeconds(seconds));
    }

    public WebDriverWait getWebDriverWait() {
        return webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void visibilityOfElement(By locator, int seconds) {
        setWebDriverWait(seconds);
        LogUtils.LOGGER.info("Waiting for element to be visible within seconds: " + seconds);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void visibilityOfElementNOFail(By locator, int seconds) {
        setWebDriverWait(seconds);
        try {
            LogUtils.LOGGER.info("Waiting for element to be visible: " + seconds);
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            LogUtils.LOGGER.info(e.getMessage());
        }
    }

    public boolean isElementDisplayed(By locator) {
        try {
            boolean isDisplayed = driver.findElement(locator).isDisplayed();
            LogUtils.LOGGER.info("Element located by " + locator + " is displayed: " + isDisplayed);
            return isDisplayed;
        } catch (NoSuchElementException e) {
            LogUtils.LOGGER.info("Element located by " + locator + " is not displayed.");
            return false;
        }
    }
}
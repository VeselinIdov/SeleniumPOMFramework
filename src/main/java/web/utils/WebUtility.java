package web.utils;

import core.utils.LogUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Random;

public class WebUtility {

    private final WebDriver driver;
    private final WaitUtility waitUtility;

    public WebUtility(WebDriver driver, WaitUtility waitUtility) {
        this.driver = driver;
        this.waitUtility = waitUtility;
    }

    public void clickElement(By elementBy) {
        LogUtils.LOGGER.info("Clicking on element: " + elementBy);
        waitUtility.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(elementBy)).click();
    }

    public void enterText(By elementBy, String text) {
        LogUtils.LOGGER.info("Entering text in field: " + elementBy);
        getElementLocator(elementBy).sendKeys(Keys.chord(Keys.CONTROL, "a"), text);
    }

    public WebElement getElementLocator(By elementBy) {
        LogUtils.LOGGER.info("Getting element locator: " + elementBy);
        return driver.findElement(elementBy);
    }

    public List<WebElement> getElementsLocator(By elementBy) {
        LogUtils.LOGGER.info("Getting elements locator: " + elementBy);
        return driver.findElements(elementBy);
    }

    public String getElementText(By elementBy) {
        LogUtils.LOGGER.info("Getting element text: " + elementBy);
        return getElementLocator(elementBy).getText();
    }

    public void scrollToElementView(By elementBy) {
        WebElement elementToScroll = driver.findElement(elementBy);
        LogUtils.LOGGER.info("Scrolling to element: " + elementToScroll);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elementToScroll);
    }

    public void performDoubleClick(By elementBy) {
        Actions actions = new Actions(driver);
        WebElement webElement = getElementLocator(elementBy);
        LogUtils.LOGGER.info("Performing double click on element: " + elementBy);
        actions.doubleClick(webElement).perform();
    }

    public void performRightClick(By elementBy) {
        Actions actions = new Actions(driver);
        WebElement webElement = getElementLocator(elementBy);
        LogUtils.LOGGER.info("Performing right click on element: " + elementBy);
        actions.contextClick(webElement).perform();
    }

    public void acceptAlert() {
        Alert alert = driver.switchTo().alert();
        LogUtils.LOGGER.info("Accepting alert with text: " + alert.getText());
        alert.accept();
    }

    public void gettingAlertText() {
        Alert alert = driver.switchTo().alert();
        LogUtils.LOGGER.info("Getting alert text equal to: " + alert.getText());
        alert.getText();
    }

    public void cancelAlert() {
        Alert alert = driver.switchTo().alert();
        LogUtils.LOGGER.info("Dismissing alert with text: " + alert.getText());
        alert.dismiss();
    }

    public void sendKeysToAlertAndAccept(String text) {
        Alert alert = driver.switchTo().alert();
        LogUtils.LOGGER.info("SendKeys to alert with text and accept it: " + alert.getText());
        alert.sendKeys(text);
        alert.accept();
    }

    public void switchToFrameByIndex(int index) {
        LogUtils.LOGGER.info("Switching to frame with index: " + index);
        driver.switchTo().frame(index);
    }

    public void switchToDefaultContent() {
        LogUtils.LOGGER.info("Switching to default content");
        driver.switchTo().defaultContent();
    }

    public static String selectRandomValueFromDropDown(WebElement dropdown, List<WebElement> options) {
        if (options.isEmpty()) {
            throw new IllegalArgumentException("Dropdown options list is empty.");
        }

        dropdown.click();
        LogUtils.LOGGER.info("Clicked on the dropdown to expand.");
        int randomIndex = new Random().nextInt(options.size());
        WebElement selectedOption = options.get(randomIndex);
        selectedOption.click();
        LogUtils.LOGGER.info("Selected option: " + selectedOption.getText());
        return selectedOption.getText();
    }
}
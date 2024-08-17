package web.decorator;
import core.utils.LogUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.utils.WaitUtility;

import java.util.List;
import java.util.Random;

public class BaseWebActions implements WebActions {

    protected final WebDriver driver;
    protected final WaitUtility waitUtility;

    public BaseWebActions(WebDriver driver, WaitUtility waitUtility) {
        this.driver = driver;
        this.waitUtility = waitUtility;
    }

    @Override
    public void clickElement(By elementBy) {
        LogUtils.LOGGER.info("Clicking on element: " + elementBy);
        waitUtility.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(elementBy)).click();
    }

    @Override
    public void enterText(By elementBy, String text) {
        LogUtils.LOGGER.info("Entering text in field: " + elementBy);
        getElementLocator(elementBy).sendKeys(Keys.chord(Keys.CONTROL, "a"), text);
    }

    @Override
    public WebElement getElementLocator(By elementBy) {
        LogUtils.LOGGER.info("Getting element locator: " + elementBy);
        return driver.findElement(elementBy);
    }

    @Override
    public List<WebElement> getElementsLocator(By elementBy) {
        LogUtils.LOGGER.info("Getting elements locator :" + elementBy);
        return driver.findElements(elementBy);
    }

    @Override
    public String getElementText(By elementBy) {
        LogUtils.LOGGER.info("Getting element text: " + elementBy);
        return getElementLocator(elementBy).getText();
    }

    @Override
    public void scrollToElementView(By elementBy) {
        WebElement elementToScroll = driver.findElement(elementBy);
        LogUtils.LOGGER.info("Scrolling to element: " + elementToScroll);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elementToScroll);
    }

    @Override
    public void performDoubleClick(By elementBy) {
        Actions actions = new Actions(driver);
        WebElement webElement = getElementLocator(elementBy);
        LogUtils.LOGGER.info("Performing double click on element: " + elementBy);
        actions.doubleClick(webElement).perform();
    }

    @Override
    public void performRightClick(By elementBy) {
        Actions actions = new Actions(driver);
        WebElement webElement = getElementLocator(elementBy);
        LogUtils.LOGGER.info("Performing right click on element: " + elementBy);
        actions.contextClick(webElement).perform();
    }

    @Override
    public void acceptAlert() {
        Alert alert = driver.switchTo().alert();
        LogUtils.LOGGER.info("Accepting alert with text: " + alert.getText());
        alert.accept();
    }

    @Override
    public String gettingAlertText() {
        Alert alert = driver.switchTo().alert();
        LogUtils.LOGGER.info("Getting alert text equal to: " + alert.getText());
        return alert.getText();
    }

    @Override
    public void cancelAlert() {
        Alert alert = driver.switchTo().alert();
        LogUtils.LOGGER.info("Dismissing alert with text: " + alert.getText());
        alert.dismiss();
    }

    @Override
    public void sendKeysToAlertAndAccept(String text) {
        Alert alert = driver.switchTo().alert();
        LogUtils.LOGGER.info("SendKeys to alert with text and accept it: " + alert.getText());
        alert.sendKeys(text);
        alert.accept();
    }

    @Override
    public void switchToFrameByIndex(int index) {
        LogUtils.LOGGER.info("Switching to frame with index: " + index);
        driver.switchTo().frame(index);
    }

    @Override
    public void switchToDefaultContent() {
        LogUtils.LOGGER.info("Switching to default content");
        driver.switchTo().defaultContent();
    }

    @Override
    public String selectRandomValueFromDropDown(WebElement dropdown, List<WebElement> options) {
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
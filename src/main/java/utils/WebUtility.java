package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class WebUtility {

    private WebDriver driver;
    private WaitUtility waitUtility;

    public WebUtility(WebDriver driver, WaitUtility waitUtility) {
        this.driver = driver;
        this.waitUtility = waitUtility;
    }

    public void clickElement(By elementBy) {
        waitUtility.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(elementBy)).click();
    }

    public void enterText(By elementBy, String text) {
        getElementLocator(elementBy).sendKeys(Keys.chord(Keys.CONTROL, "a"), text);
    }

    public WebElement getElementLocator(By elementBy) {
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
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elementToScroll);
    }
}
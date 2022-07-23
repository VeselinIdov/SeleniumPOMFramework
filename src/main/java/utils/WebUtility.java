package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WebUtility {

    private WebDriver driver;

    public WebUtility(WebDriver driver) {
        this.driver = driver;
    }

    public void clickElement(By elementBy) {
        getElementLocator(elementBy).click();
    }

    public void enterText(By elementBy, String text) {
        getElementLocator(elementBy).sendKeys(text);
    }

    private WebElement getElementLocator(By elementBy) {
        return driver.findElement(elementBy);
    }

    public List<WebElement> getAllElements(By elementBy) {
        return driver.findElements(elementBy);
    }

    public String getElementText(By locator) {
        return getElementLocator(locator).getText();
    }
}
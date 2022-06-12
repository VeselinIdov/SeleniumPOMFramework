package configurations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class WebActions {

    private static void waitForElement(By elementBy) {
        BaseTest.webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }

    private static void waitForElementToBeClickable(By elementBy) {
        BaseTest.webDriverWait.until(ExpectedConditions.elementToBeClickable(elementBy));
    }

    public static void click(By elementBy) {
        waitForElementToBeClickable(elementBy);
        BaseTest.driver.findElement(elementBy).click();
    }

    public static void enterText(By elementBy, String text) {
        waitForElement(elementBy);
        BaseTest.driver.findElement(elementBy).sendKeys(text);
    }

    public static WebElement getElement(By elementBy) {
        return BaseTest.driver.findElement(elementBy);
    }

    public static List<WebElement> getAllElements(By elementBy) {
        waitForElement(elementBy);
        return BaseTest.driver.findElements(elementBy);
    }
}

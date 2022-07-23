package pages;

import configurations.BasePage;
import configurations.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ElementsPage extends BasePage {

    private final By productNames = By.cssSelector("[class=\"newsletters\"]");

    public void selectProductByName() {
        waitUtility.getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(productNames));
        BaseTest.driver.switchTo();
        webUtility.clickElement(productNames);
    }
}
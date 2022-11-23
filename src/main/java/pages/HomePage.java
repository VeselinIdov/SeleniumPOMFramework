package pages;

import configurations.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    private By elementLocator = By.cssSelector("[class=\"login\"]");

    public HomePage(String expectedURL) {
        super(expectedURL);
    }

    @Step("click no button")
    public void clickOnElement(){
        waitUtility.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(elementLocator));
        waitUtility.visibilityOfElement(elementLocator, 5);
        webUtility.clickElement(elementLocator);
        System.out.println(webUtility.getElementText(elementLocator));
    }


    @Step("Text of button")
    public void getText(){
        waitUtility.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(elementLocator));
        waitUtility.visibilityOfElement(elementLocator, 5);
        webUtility.getElementText(elementLocator);
    }

}

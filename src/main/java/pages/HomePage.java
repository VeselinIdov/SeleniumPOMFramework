package pages;

import configurations.BasePage;
import configurations.WebDriverFactory;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    private By elementLocator = By.cssSelector("[class=\"login\"]");

    public HomePage() {
        super(WebDriverFactory.getDriver().getCurrentUrl());
    }

    @Step("Click on button")
    public void clickOnElement(){
        waitUtility.visibilityOfElementNOFail(elementLocator, 5);
        waitUtility.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(elementLocator));
        waitUtility.visibilityOfElement(elementLocator, 5);
        webUtility.clickElement(elementLocator);
        System.out.println(webUtility.getElementText(elementLocator));
    }


    @Step("Text of button")
    public String getElementText(){
       return webUtility.getElementText(elementLocator);
    }

}

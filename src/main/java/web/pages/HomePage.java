package web.pages;

import web.base.BasePage;
import web.utils.WebDriverFactory;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class HomePage extends BasePage {
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By doubleClickButton = By.id("rightClickBtn");
    private By cookieButton= By.xpath("//button[@aria-label='Consent']");
    private By alertButton= By.id("promtButton");

    public HomePage() {
        super(WebDriverFactory.getDriver().getCurrentUrl());
    }

    @Step("Login as user")
    public void loginAsUser(String username, String password) {
        loggingWebActionsDecorator.enterText(usernameField, username);
        loggingWebActionsDecorator.enterText(passwordField, password);
        loggingWebActionsDecorator.clickElement(loginButton);
    }

    public void performDoubleClick(){
        loggingWebActionsDecorator.performDoubleClick(doubleClickButton);
    }

    public void performRightClick(){
        loggingWebActionsDecorator.performRightClick(doubleClickButton);
    }

    public void acceptCookie(){
        waitUtility.visibilityOfElementNOFail(cookieButton,10);
        loggingWebActionsDecorator.clickElement(cookieButton);
    }

    public void triggerAlert(){
        loggingWebActionsDecorator.clickElement(alertButton);
        loggingWebActionsDecorator.sendKeysToAlertAndAccept("random");
    }

    public void frame(){
        loggingWebActionsDecorator.switchToFrameByIndex(1);
    }
}
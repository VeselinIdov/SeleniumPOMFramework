package web.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
        webUtility.enterText(usernameField, username);
        webUtility.enterText(passwordField, password);
        webUtility.clickElement(loginButton);
    }

    public void performDoubleClick(){
        webUtility.performDoubleClick(doubleClickButton);
    }

    public void performRightClick(){
        webUtility.performRightClick(doubleClickButton);
    }

    public void acceptCookie(){
        waitUtility.visibilityOfElementNOFail(cookieButton,10);
        webUtility.clickElement(cookieButton);
    }

    public void triggerAlert(){
        webUtility.clickElement(alertButton);
        webUtility.sendKeysToAlertAndAccept("random");
    }

    public void frame(){
        webUtility.switchToFrameByIndex(1);
    }
}
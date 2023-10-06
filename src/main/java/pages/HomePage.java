package pages;

import core.BasePage;
import core.WebDriverFactory;
import core.utils.WebUtility;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");

    public HomePage() {
        super(WebDriverFactory.getDriver().getCurrentUrl());
    }

    @Step("Login as user")
    public void loginAsUser(String username, String password) {
        webUtility.enterText(usernameField, username);
        webUtility.enterText(passwordField, password);
        webUtility.clickElement(loginButton);
    }
}
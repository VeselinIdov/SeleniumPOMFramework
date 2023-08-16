package pages;

import core.BasePage;
import core.WebDriverFactory;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class HomePage extends BasePage {
    private By usernameField = By.name("username");
    private By loginButton = By.xpath("//input[@value=\"Log In\"]");

    public HomePage() {
        super(WebDriverFactory.getDriver().getCurrentUrl());
    }

    public void enterUsername(String value){
        webUtility.enterText(usernameField, value);
    }

    @Step("Click on button")
    public void clickOnLoginButton(){
        webUtility.clickElement(loginButton);
        System.out.println(webUtility.getElementText(loginButton));
    }
}

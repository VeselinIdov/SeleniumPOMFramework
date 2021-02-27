package pages;

import configurations.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterForm extends BasePage {

	@FindBy(xpath = "//li[contains(@class, 'login')]//p[contains(text(), 'ogin/Registe')]")
	private WebElement loginButton;

	@FindBy(xpath = "//div[contains(@class, 'form loginBox')]//input[contains(@value, 'Login')]")
	private WebElement loginFormButton;

	@FindBy(xpath = "//div[contains(@class, 'modal-footer')]//a[contains(text(), 'reate an accoun')]")
	private WebElement registerButton;

	@FindBy(xpath = "//div[contains(@class, 'registerBox')]//input[contains(@name, \"email\")]")
	private WebElement emailFieldInput;

	@FindBy(xpath = "//div[contains(@class, 'registerBox')]//input[contains(@name, \"password\")][1]")
	private WebElement passwordInputField;

	@FindBy(xpath = "//div[contains(@class, 'registerBox')]//input[contains(@name, \"password_confirmation\")]")
	private WebElement repeatPasswordInputField;

	@FindBy(xpath = "//div[contains(@class, 'registerBox')]//input[contains(@value,\"reate accoun\")]")
	private WebElement submitButton;




    public RegisterForm() {
        super();
    }


    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getLoginFormButton() {
        return loginFormButton;
    }

    public WebElement getRegisterButton() {
        return registerButton;
    }

    public WebElement getEmailFieldInput() {
        return emailFieldInput;
    }

    public WebElement getPasswordInputField() {
        return passwordInputField;
    }

    public WebElement getRepeatPasswordInputField() {
        return repeatPasswordInputField;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }
}

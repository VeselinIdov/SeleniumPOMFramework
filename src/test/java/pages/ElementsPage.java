package pages;

import configurations.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElementsPage extends BasePage {

	@FindBy(xpath = "//ul[contains(@class, \"menu-list\")]//span[contains(text(), 'ext Box')]")
	private WebElement textBoxtNav;

	@FindBy(xpath = "//div[contains(@class, \"main-header\") and contains(., 'lements')]")
	private WebElement elementsPageText;

	@FindBy(xpath = "//input[@id=\"userName\"]")
	private WebElement usernameInput;

	@FindBy(xpath = "//input[@id=\"userEmail\"]")
	private WebElement emailInput;

    @FindBy(xpath = "//textarea[@id=\"currentAddress\"]")
    private WebElement currentAddress;

    @FindBy(xpath = "//textarea[@id=\"permanentAddress\"]")
    private WebElement pernamentAddress;

	@FindBy(xpath = "//button[@id=\"submit\"]")
	private WebElement submitButton;

	@FindBy(xpath = "//div[@id=\"output\"][//text()[contains(text(),'testUser') or contains(., 'test@email.ee')]]")
	private WebElement outPutData;

	@FindBy(xpath = "//ul[contains(@class, \"menu-list\")]//span[contains(text(), 'adio Button')]")
	private WebElement radioButtonNav;

	@FindBy(xpath = "//label[contains(@for, \"yesRadio\")]")
	private WebElement radioButtonYes;

	@FindBy(xpath = "//ul[contains(@class, \"menu-list\")]//span[contains(text(), 'eb Tables')]")
	private WebElement webTablesNav;

	@FindBy(id = "searchBox")
	private WebElement searchField;

	@FindBy(xpath = "//div[contains(@role,\"rowgroup\")]//div[contains(@class, \"rt-td\") and contains(text(), 'Cierra')]")
	private WebElement assertSearchData;

	@FindBy(xpath = "")
	private WebElement testNotContainsLocator;









    public ElementsPage() {
        super();
    }

    public WebElement getTextBoxtNav() {
        return textBoxtNav;
    }

    public WebElement getElementsPageText() {
        return elementsPageText;
    }

    public WebElement getUsernameInput() {
        return usernameInput;
    }

    public WebElement getEmailInput() {
        return emailInput;
    }

    public WebElement getCurrentAddress() {
        return currentAddress;
    }

    public WebElement getPernamentAddress() {
        return pernamentAddress;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public WebElement getOutPutData() {
        return outPutData;
    }

    public WebElement getRadioButtonNav() {
        return radioButtonNav;
    }

    public WebElement getRadioButtonYes() {
        return radioButtonYes;
    }

    public WebElement getWebTablesNav() {
        return webTablesNav;
    }

    public WebElement getSearchField() {
        return searchField;
    }

    public WebElement getAssertSearchData() {
        return assertSearchData;
    }
}

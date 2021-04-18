package pages;

import configurations.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

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

	@FindBy(xpath = "//ul[contains(@class, \"menu-list\")]//span[contains(text(), 'ractice Form')]")
	private WebElement practiseFormNav;

	@FindBy(xpath = "//select[contains(@id,\"testingDropdown\")]")
	private WebElement clickDropDown;

	@FindBy(xpath = "//select[contains(@id,\"testingDropdown\")]/option")
	private List<WebElement> dropDownValues;


	public void pillPage(String username, String email){

	    this.usernameInput.sendKeys(username);
	    this.emailInput.sendKeys(email);
    }



    public WebElement getTextBoxtNav() {
        return textBoxtNav;
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

    public WebElement getClickDropDown() {
        return clickDropDown;
    }

    public List<WebElement> getDropDownValues() {
        return dropDownValues;
    }
}

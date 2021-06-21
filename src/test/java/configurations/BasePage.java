package configurations;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

abstract public class BasePage {

	@FindBy(css = "dsdas")
	private WebElement globalTest;



    public BasePage() {

        PageFactory.initElements(WebDriverConfig.chooseDriver(PropertyManager.getChooseBrowser()), this);
        System.out.println("page called");
    }


    public WebElement getGlobalTest() {
        return globalTest;
    }
}
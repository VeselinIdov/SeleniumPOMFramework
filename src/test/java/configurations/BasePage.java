package configurations;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	@FindBy(css = "dsdas")
	private WebElement globalTest;



    public BasePage() {
        PageFactory.initElements(WebDriverConfig.chooseDriver(PropertyManager.getProperty().getChooseBrowser()), this);
    }


    public WebElement getGlobalTest() {
        return globalTest;
    }
}
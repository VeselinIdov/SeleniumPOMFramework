package configurations;
import org.openqa.selenium.support.PageFactory;

public class BasePage {


    public BasePage() {
        PageFactory.initElements(WebDriverConfig.driver, this);
    }


}
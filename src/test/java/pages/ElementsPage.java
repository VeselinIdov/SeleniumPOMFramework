package pages;

import configurations.BasePage;
import configurations.WebActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class ElementsPage extends BasePage {

    private final By productNames = By.cssSelector("[class=\"product-name\"]");

    public void selectProductByName() {
        List<WebElement> element = WebActions.getAllElements(productNames);

        for (WebElement element1 : element) {
            if (element1.getText().equals("Printed Chiffon Dress")) {
                element1.click();
            }
        }
    }
}

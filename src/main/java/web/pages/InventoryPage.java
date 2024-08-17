package web.pages;

import core.configurations.ConfigurationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import web.base.BasePage;

import java.util.List;

public class InventoryPage extends BasePage {

    private final By addToCartButton = By.id("add-to-cart-sauce-labs-backpack");
    private final By cartIcon = By.xpath("//a[@class='shopping_cart_link']");
    private final By removeItem = By.id("remove-sauce-labs-bike-light");
    private final By getItemText = By.className("inventory_item_name");
    private final By addCartButtonsList = By.xpath("//button[text()='Add to cart']");

    public InventoryPage() {
        super(ConfigurationManager.configuration().getUrl() + "inventory.html");
    }

    public void removeItemFromCart() {
        loggingWebActionsDecorator.clickElement(removeItem);
    }

    public void navigateToCartPage() {
        loggingWebActionsDecorator.clickElement(cartIcon);
    }

    public void addItemToCart() {
        loggingWebActionsDecorator.clickElement(addToCartButton);
    }

    public String getItemText() {
        return loggingWebActionsDecorator.getElementText(getItemText);
    }

    public void clickOnButtons() {
        List<WebElement> buttons = loggingWebActionsDecorator.getElementsLocator(addCartButtonsList);
        for (WebElement webElement : buttons) {
            webElement.click();
        }
    }
}

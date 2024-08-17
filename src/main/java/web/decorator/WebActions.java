package web.decorator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public interface WebActions {
    void clickElement(By elementBy);

    void enterText(By elementBy, String text);

    WebElement getElementLocator(By elementBy);

    List<WebElement> getElementsLocator(By elementBy);

    String getElementText(By elementBy);

    void scrollToElementView(By elementBy);

    void performDoubleClick(By elementBy);

    void performRightClick(By elementBy);

    void acceptAlert();

    String gettingAlertText();

    void cancelAlert();

    void sendKeysToAlertAndAccept(String text);

    void switchToFrameByIndex(int index);

    void switchToDefaultContent();

    String selectRandomValueFromDropDown(WebElement dropdown, List<WebElement> options);
}
package web.decorator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class WebActionsDecorator implements WebActions {

    protected final WebActions decoratedWebActions;

    public WebActionsDecorator(WebActions decoratedWebActions) {
        this.decoratedWebActions = decoratedWebActions;
    }

    @Override
    public void clickElement(By elementBy) {
        decoratedWebActions.clickElement(elementBy);
    }

    @Override
    public void enterText(By elementBy, String text) {
        decoratedWebActions.enterText(elementBy, text);
    }

    @Override
    public WebElement getElementLocator(By elementBy) {
        return decoratedWebActions.getElementLocator(elementBy);
    }

    @Override
    public List<WebElement> getElementsLocator(By elementBy) {
        return decoratedWebActions.getElementsLocator(elementBy);
    }

    @Override
    public String getElementText(By elementBy) {
        return decoratedWebActions.getElementText(elementBy);
    }

    @Override
    public void scrollToElementView(By elementBy) {
        decoratedWebActions.scrollToElementView(elementBy);
    }

    @Override
    public void performDoubleClick(By elementBy) {
        decoratedWebActions.performDoubleClick(elementBy);
    }

    @Override
    public void performRightClick(By elementBy) {
        decoratedWebActions.performRightClick(elementBy);
    }

    @Override
    public void acceptAlert() {
        decoratedWebActions.acceptAlert();
    }

    @Override
    public String gettingAlertText() {
        return decoratedWebActions.gettingAlertText();
    }

    @Override
    public void cancelAlert() {
        decoratedWebActions.cancelAlert();
    }

    @Override
    public void sendKeysToAlertAndAccept(String text) {
        decoratedWebActions.sendKeysToAlertAndAccept(text);
    }

    @Override
    public void switchToFrameByIndex(int index) {
        decoratedWebActions.switchToFrameByIndex(index);
    }

    @Override
    public void switchToDefaultContent() {
        decoratedWebActions.switchToDefaultContent();
    }

    @Override
    public String selectRandomValueFromDropDown(WebElement dropdown, List<WebElement> options) {
        return decoratedWebActions.selectRandomValueFromDropDown(dropdown, options);
    }
}
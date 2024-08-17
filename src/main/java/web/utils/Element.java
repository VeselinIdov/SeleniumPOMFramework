package web.utils;

import org.openqa.selenium.By;

public abstract class Element {
    public abstract By getBy();
    public abstract String getBText();
    public abstract Boolean isDisplayed();
    public abstract void enterText();
    public abstract void clickElement();
}
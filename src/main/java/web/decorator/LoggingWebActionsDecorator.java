package web.decorator;

import org.openqa.selenium.By;
import core.utils.LogUtils;

public class LoggingWebActionsDecorator extends WebActionsDecorator {

    public LoggingWebActionsDecorator(WebActions decoratedWebActions) {
        super(decoratedWebActions);
    }

    @Override
    public void clickElement(By elementBy) {
        LogUtils.LOGGER.info("Logging: Clicking on element: " + elementBy);
        super.clickElement(elementBy);
    }

    @Override
    public void enterText(By elementBy, String text) {
        LogUtils.LOGGER.info("Logging: Entering text in field: " + elementBy);
        super.enterText(elementBy, text);
    }

    // Similarly override other methods to add logging

    @Override
    public String getElementText(By elementBy) {
        String text = super.getElementText(elementBy);
        LogUtils.LOGGER.info("Logging: Text retrieved from element: " + elementBy + " is " + text);
        return text;
    }
}
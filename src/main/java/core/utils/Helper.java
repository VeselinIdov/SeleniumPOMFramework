package core.utils;

import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.Random;

public class Helper {

    public static void waitForSeconds(int timeoutInSeconds) {
        try {
            Thread.sleep(timeoutInSeconds * 1000L);
        } catch (InterruptedException e) {
            LogUtils.LOGGER.info(e.getMessage());
        }
    }

    public static String randomData(String text) {
        long value = System.currentTimeMillis();
        return value + text;
    }

    public static String selectRandomValueFromDropDown(WebElement clickOnDropDown, List<WebElement> selectValueFromDropDown) {
        clickOnDropDown.click();
        Random rand = new Random();
        int options = selectValueFromDropDown.size();
        int list = rand.nextInt(options);
        selectValueFromDropDown.get(list).click();
        return selectValueFromDropDown.get(list).getText();
    }
}
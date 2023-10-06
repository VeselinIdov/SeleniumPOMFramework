package core.utils;

import core.WebDriverFactory;
import org.openqa.selenium.html5.WebStorage;

public class Session {

    public static void clearSessionStorage() {
        WebStorage webStorage = (WebStorage) WebDriverFactory.getDriver();
        LogUtils.LOGGER.info("Clearing session storage of browser");
        webStorage.getSessionStorage().clear();
    }

    public static void clearLocalStorage() {
        WebStorage webStorage = (WebStorage) WebDriverFactory.getDriver();
        LogUtils.LOGGER.info("Clearing local storage of browser");
        webStorage.getLocalStorage().clear();
    }
}
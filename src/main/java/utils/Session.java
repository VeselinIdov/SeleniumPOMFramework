package utils;

import configurations.WebDriverFactory;
import org.openqa.selenium.html5.WebStorage;

public class Session {

    public static void clearSessionStorage() {
        WebStorage webStorage = (WebStorage) WebDriverFactory.getDriver();
        webStorage.getSessionStorage().clear();
    }

    public static void clearLocalStorage() {
        WebStorage webStorage = (WebStorage) WebDriverFactory.getDriver();
        webStorage.getLocalStorage().clear();
    }
}
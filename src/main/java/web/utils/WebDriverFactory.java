package web.utils;

import core.configurations.ConfigurationManager;
import core.utils.LogUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class WebDriverFactory {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private WebDriverFactory() {
    }

    public static void createDriverInstance() {
        switch (ConfigurationManager.configuration().getBrowser()) {
            case "chrome":
                driver.set(WebDriverManager.chromedriver().create());
                break;
            case "firefox":
                driver.set(WebDriverManager.firefoxdriver().create());
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser");
        }
        driver.get().manage().window().maximize();
        LogUtils.LOGGER.info("WebDriver instance created successfully");
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (null != driver.get()) {
            driver.get().quit();
            driver.remove();
            LogUtils.LOGGER.info("WebDriver instance quit successfully");
        }
    }
}
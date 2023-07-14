package configurations;

import configurations.config.ConfigurationManager;
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
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
          driver.get().manage().window().maximize();
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (null != driver.get()) {
            driver.get().quit();
            driver.remove();
        }
    }
}

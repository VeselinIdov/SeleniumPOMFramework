package configurations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

class WebDriverFactory {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private WebDriverFactory() {
    }

    private static WebDriver createDriverInstance(String browser) {
        switch (browser) {
            case "chrome":
                driver.set(WebDriverManager.chromedriver().create());
                driver.get().manage().window().maximize();
                break;
            case "firefox":
                driver.set(WebDriverManager.firefoxdriver().create());
                driver.get().manage().window().maximize();
                break;
        }
        return driver.get();
    }

    static WebDriver getDriver() {
        if (null == createDriverInstance(PropertyManager.getInstance().getValue("browser"))) {
            driver.set(createDriverInstance(PropertyManager.getInstance().getValue("browser")));
        }
        return driver.get();
    }

    static void quitDriver() {
        if (null != driver.get()) {
            driver.get().quit();
            driver.remove();
        }
    }
}
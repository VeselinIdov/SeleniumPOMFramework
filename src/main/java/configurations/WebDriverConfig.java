package configurations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

class WebDriverConfig {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private WebDriverConfig() {
    }

    private static WebDriver chooseDriver(String browser) {
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver());
                driver.get().manage().window().maximize();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver.set(new FirefoxDriver());

                driver.get().manage().window().maximize();
                break;
        }
        return driver.get();
    }

    static WebDriver getDriver() {
        if (null == chooseDriver(PropertyManager.getBrowserType())) {
            driver.set(chooseDriver(PropertyManager.getBrowserType()));
        }
        return driver.get();
    }

    static void quitDriver() {
        if (null != driver) {
            driver.get().quit();
            driver.remove();
        }
    }
}
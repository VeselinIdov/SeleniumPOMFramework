package configurations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

class WebDriverConfig {

    private static WebDriver driver;

    private WebDriverConfig() {
    }

    private static WebDriver chooseDriver(String browser) {
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                break;
        }
        return driver;
    }

    static WebDriver getDriver() {
        if (null == chooseDriver(PropertyManager.getBrowserType())) {
            driver = chooseDriver(PropertyManager.getBrowserType());
        }
        return driver;
    }

    static void quitDriver() {
        if (null != driver) {
            driver.quit();
        }
    }
}
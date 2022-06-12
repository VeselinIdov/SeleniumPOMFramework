package configurations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

class WebDriverConfig {

    private static WebDriver driver;
    private static WebDriverWait wait;

    private WebDriverConfig() {
    }

    static WebDriver chooseDriver(String browser) {
        if (driver == null) {

            switch (browser) {
                case "chrome":
                    driver = WebDriverManager.chromedriver().create();
                    break;
                case "firefox":
                    driver = WebDriverManager.firefoxdriver().create();
                    break;
            }
        }
        return driver;
    }

    static WebDriverWait getWait() {
        if (wait == null) {
            wait = new WebDriverWait(chooseDriver(PropertyManager.getBrowserType()), 10);
        }
        return wait;
    }
}

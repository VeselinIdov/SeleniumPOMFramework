package configurations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

class WebDriverConfig {

    static WebDriver driver;

    static void chooseDriver(String browser) {
        if (browser.equals("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            driver = new FirefoxDriver();
        }
    }

}

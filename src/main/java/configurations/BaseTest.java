package configurations;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.Session;

public class BaseTest {

    public static WebDriver driver;

    @BeforeMethod
    public void testSetup() {
        driver = WebDriverFactory.getDriver();
        driver.navigate().to(PropertyManager.getInstance().getValue("url.base"));
        Session.clearLocalStorage();
        Session.clearSessionStorage();
    }

    @AfterMethod
    public void closeTests() {
        ScreenShotOnFailure.takeSnapShot();
        WebDriverFactory.quitDriver();
    }
}
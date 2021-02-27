package configurations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver() {
        return WebDriverConfig.driver;
    }

    protected WebDriverWait getWait() {
        WebDriverWait wait = new WebDriverWait(WebDriverConfig.driver, 1);
        return wait;
    }

    protected void waitForSeconds(int timeoutInSeconds) {
        try {
            Thread.sleep(timeoutInSeconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @BeforeMethod
    public void startMethod() {
        WebDriverConfig.chooseDriver(PropertyManager.getProperty().getChooseBrowser());
        driver().navigate().to(PropertyManager.getProperty().getBaseURL());
        driver().manage().deleteAllCookies();
        driver().manage().window().maximize();
    }

    @AfterMethod
    public void closeMethod() {
        ScreenShotOnFailure screenShotOnFailure = new ScreenShotOnFailure();
        screenShotOnFailure.takeSnapShot();
        driver().quit();
    }
}
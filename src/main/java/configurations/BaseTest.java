package configurations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    public static WebDriver driver;
    public static WebDriverWait webDriverWait = WebDriverConfig.getWait();

    @BeforeClass
    public void startMethod() {
        driver = WebDriverConfig.chooseDriver(PropertyManager.getBrowserType());

        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void testSetup(){
        driver = WebDriverConfig.chooseDriver(PropertyManager.getBrowserType());
        driver.navigate().to(PropertyManager.getBaseURL());
        driver.manage().deleteAllCookies();
        Session.clearLocalStorage();
        Session.clearSessionStorage();
    }


    @AfterMethod
    public void closeTests() {
        ScreenShotOnFailure.takeSnapShot();
    }

    @AfterClass
    public void afterTests(){
        if (driver!=null){
            driver.quit();
        }
    }
}
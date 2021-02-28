package configurations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.List;
import java.util.Random;

public class BaseTest {

    protected WebDriver driver() {

        return WebDriverConfig.driver;
    }

    protected WebDriverWait getWait() {

        WebDriverWait wait = new WebDriverWait(WebDriverConfig.driver, 15);
        return wait;
    }

    protected void waitForSeconds(int timeoutInSeconds) {

        try {
            Thread.sleep(timeoutInSeconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected String randomData(String text) {

        long value = System.currentTimeMillis();
        return value + text;
    }

    protected void selectRandomValueFromDropDown(WebElement clickOnDropDown, List<WebElement> selectValueFromDropDown) {

        clickOnDropDown.click();
        Random rand = new Random();
        int options = selectValueFromDropDown.size();
        int list = rand.nextInt(options);
        selectValueFromDropDown.get(list).click();
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
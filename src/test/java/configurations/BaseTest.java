package configurations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.List;
import java.util.Random;

public class BaseTest{


    protected WebDriver driver =  WebDriverConfig.chooseDriver(PropertyManager.getChooseBrowser());
    protected WebDriverWait getWait = WebDriverConfig.getWait();

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

    protected String selectRandomValueFromDropDown(WebElement clickOnDropDown, List<WebElement> selectValueFromDropDown) {

        clickOnDropDown.click();
        Random rand = new Random();
        int options = selectValueFromDropDown.size();
        int list = rand.nextInt(options);
        selectValueFromDropDown.get(list).click();

        return selectValueFromDropDown.get(list).getText();
    }

    @BeforeMethod
    public void startMethod() {


        driver.navigate().to(PropertyManager.getBaseURL());
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void closeMethod() {

        ScreenShotOnFailure screenShotOnFailure = new ScreenShotOnFailure();
        screenShotOnFailure.takeSnapShot();
        driver.quit();
    }
}
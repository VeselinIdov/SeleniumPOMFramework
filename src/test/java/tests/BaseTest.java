package tests;

import configurations.ScreenShotOnFailure;
import configurations.WebDriverFactory;
import configurations.config.ConfigurationManager;
import reports.AllureManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.Session;

public abstract class BaseTest {

    @BeforeSuite
    public void beforeSuite() {
        AllureManager.setAllureEnvironmentInformation();
    }

    @BeforeMethod
    public void testSetup() {
        WebDriverFactory.createDriverInstance();
        WebDriverFactory.getDriver().navigate().to(ConfigurationManager.configuration().getUrl());
        Session.clearLocalStorage();
        Session.clearSessionStorage();
    }

    @AfterMethod
    public void closeTests() {
        ScreenShotOnFailure.takeSnapShot();
        AllureManager.takeScreenshotToAttachOnAllureReport();
        WebDriverFactory.quitDriver();
    }
}
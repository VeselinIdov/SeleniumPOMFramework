package web.base;

import core.utils.ScreenShotOnFailure;
import core.configurations.ConfigurationManager;
import org.testng.ITestResult;
import core.reports.AllureManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import web.utils.WebDriverFactory;

public abstract class BaseTest {

    @BeforeSuite
    public void beforeSuite() {
        AllureManager.setAllureEnvironmentInformation();
    }

    @BeforeMethod
    public void testSetup() {
        WebDriverFactory.createDriverInstance();
        WebDriverFactory.getDriver().navigate().to(ConfigurationManager.configuration().getUrl());
    }

    @AfterMethod
    public void closeTests(ITestResult result) {
        ScreenShotOnFailure.takeScreenShotOnFailure(result);
        AllureManager.takeScreenshotToAttachOnAllureReport();
        WebDriverFactory.quitDriver();
    }
}
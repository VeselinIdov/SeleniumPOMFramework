package core.utils;

import web.utils.WebDriverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class ScreenShotOnFailure {

    public static void takeScreenShotOnFailure(ITestResult testResult) {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            File scrFile = ((TakesScreenshot) WebDriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
            try {
                LogUtils.LOGGER.info("Capturing screenshot on failure to '/images' folder");
                FileUtils.copyFile(scrFile, new File("images", System.currentTimeMillis() + ".png"));
            } catch (IOException e) {
                LogUtils.LOGGER.info("Failed to capture screenshot: " + e.getMessage());
            }
        }
    }
}
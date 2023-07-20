package configurations;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import utils.LogUtils;

import java.io.File;
import java.io.IOException;

public class ScreenShotOnFailure {

    public static void takeScreenShotOnFailure(ITestResult testResult) {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            File scrFile = ((TakesScreenshot) WebDriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(scrFile, new File("images", System.currentTimeMillis() + ".png"));
            } catch (IOException e) {
                LogUtils.LOGGER.info("Failed to capture screenshot: " + e.getMessage());
            }
        }
    }
}
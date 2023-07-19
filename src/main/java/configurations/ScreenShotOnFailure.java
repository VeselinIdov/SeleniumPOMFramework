package configurations;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.LogUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ScreenShotOnFailure {

    public static void takeSnapShot() {
        try {
            TakesScreenshot scrShot = ((TakesScreenshot) WebDriverFactory.getDriver());
            File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
            Path destPath = Paths.get("images", System.currentTimeMillis() + ".png");
            Files.copy(srcFile.toPath(), destPath);
        } catch (IOException e) {
            LogUtils.LOGGER.info("Failed to capture screenshot: " + e.getMessage());
        }
    }
}
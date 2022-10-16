package configurations;

import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class ScreenShotOnFailure {

    public static void takeSnapShot() {
        TakesScreenshot scrShot = ((TakesScreenshot) WebDriverFactory.getDriver());
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File("images\\" + System.currentTimeMillis() + ".png");
        try {
            FileUtils.copyFile(SrcFile, DestFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
package configurations;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;

class ScreenShotOnFailure{

    void takeSnapShot() {
        TakesScreenshot scrShot = ((TakesScreenshot) WebDriverConfig.chooseDriver(PropertyManager.getChooseBrowser()));
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File("E:\\SeleniumFramework\\images\\" + System.currentTimeMillis() + ".png");
        try {
            FileUtils.copyFile(SrcFile, DestFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

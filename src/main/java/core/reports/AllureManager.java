package core.reports;

import core.WebDriverFactory;
import io.qameta.allure.Attachment;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.openqa.selenium.OutputType.BYTES;

public class AllureManager {

    private AllureManager() {
    }

    public static void setAllureEnvironmentInformation() {
        String envData = "<environment>" +
                "    <parameter>" +
                "        <key>Browser</key>" +
                "        <value>Chrome</value>" +
                "    </parameter>" +
                "    <parameter>" +
                "        <key>Browser.Version</key>" +
                "        <value>63.0</value>" +
                "    </parameter>" +
                "    <parameter>" +
                "        <key>Stand</key>" +
                "        <value>Production</value>" +
                "    </parameter>" +
                "</environment>";

        File filePath = new File("allure-results/environment.xml");
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(envData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Attachment(value = "Failed test screenshot", type = "image/png")
    public static byte[] takeScreenshotToAttachOnAllureReport() {
        return ((TakesScreenshot) WebDriverFactory.getDriver()).getScreenshotAs(BYTES);
    }
}
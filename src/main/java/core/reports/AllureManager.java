package core.reports;

import web.utils.WebDriverFactory;
import core.utils.LogUtils;
import io.qameta.allure.Attachment;
import lombok.SneakyThrows;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileWriter;

import static org.openqa.selenium.OutputType.BYTES;

public class AllureManager {

    private AllureManager() {
    }

    @SneakyThrows
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
            LogUtils.LOGGER.info("Saving Allure environment data to: " + filePath);
            fileWriter.write(envData);
        }
    }

    @Attachment(value = "Failed test screenshot", type = "image/png")
    public static void takeScreenshotToAttachOnAllureReport() {
        ((TakesScreenshot) WebDriverFactory.getDriver()).getScreenshotAs(BYTES);
    }
}
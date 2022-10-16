package configurations.reports;

import com.github.automatedowl.tools.AllureEnvironmentWriter;
import com.google.common.collect.ImmutableMap;
import configurations.WebDriverFactory;
import io.qameta.allure.Attachment;
import org.openqa.selenium.TakesScreenshot;

import static configurations.config.ConfigurationManager.configuration;
import static org.openqa.selenium.OutputType.BYTES;

public class AllureManager {

    private AllureManager() {
    }

    public static void setAllureEnvironmentInformation() {
        AllureEnvironmentWriter.allureEnvironmentWriter(
                ImmutableMap.<String, String>builder().
                        put("Test URL", configuration().getUrl()).
                        put("Local browser", configuration().getBrowser()).
                        build());
    }
}
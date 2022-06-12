package configurations;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

class PropertyManager {
    private static String browserType;
    private static String baseURL;

    static {
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream("config.properties"));
        } catch (IOException e) {
            System.out.println("Configuration properties file cannot be found");
        }
        browserType = prop.getProperty("chooseBrowser");
        baseURL = prop.getProperty("baseURL");
    }

    static String getBrowserType() {
        return browserType;
    }

    static String getBaseURL() {
        return baseURL;
    }
}

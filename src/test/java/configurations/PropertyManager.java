package configurations;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

class PropertyManager {

    private static String chooseBrowser;
    private static String baseURL;

    private PropertyManager() {
    }

    static {
        Properties prop = new Properties();

        //Read configuration.properties file
        try {
            prop.load(new FileInputStream("config.properties"));
        } catch (IOException e) {
            System.out.println("Configuration properties file cannot be found");
        }

        //Get properties from configuration.properties
        chooseBrowser = prop.getProperty("chooseBrowser");
        baseURL = prop.getProperty("baseURL");
    }

    static String getChooseBrowser() {
        return chooseBrowser;
    }

    static String getBaseURL() {
        return baseURL;
    }

}

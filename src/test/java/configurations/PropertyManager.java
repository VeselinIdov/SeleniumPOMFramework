package configurations;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

class PropertyManager {

    private String chooseBrowser;
    private String baseURL;

    //Creating instance/object of a class
    static PropertyManager getProperty() {
        PropertyManager property = new PropertyManager();
        property.loadData();
        return property;
    }

    private void loadData() {
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

    String getChooseBrowser() {
        return chooseBrowser;
    }

    String getBaseURL() {
        return baseURL;
    }

}

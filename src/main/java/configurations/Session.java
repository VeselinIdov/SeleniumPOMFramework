package configurations;

import org.openqa.selenium.html5.WebStorage;

public class Session{

    public static void clearSessionStorage(){
        WebStorage webStorage =(WebStorage)BaseTest.driver;
        webStorage.getSessionStorage().clear();
    }

    public static void clearLocalStorage(){
        WebStorage webStorage =(WebStorage)BaseTest.driver;
        webStorage.getLocalStorage().clear();
    }
}

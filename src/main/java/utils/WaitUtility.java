package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtility {

    private WebDriverWait webDriverWait;
    private WebDriver driver;

    public WaitUtility(WebDriver driver) {
        this.driver = driver;
    }

    private void setWebDriverWaitWithSeconds(int seconds) {
        this.webDriverWait = new WebDriverWait(this.driver, Duration.ofSeconds(seconds));
    }

    public WebDriverWait getWebDriverWait() {
        return webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void visibilityOfElement(By locator, int seconds) {
        setWebDriverWaitWithSeconds(seconds);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
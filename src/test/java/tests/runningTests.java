package tests;

import configurations.BaseTest;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DemoQAPage;
import pages.ElementsPage;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class runningTests extends BaseTest {




    @Test
    void demoQAPractise() {

        DemoQAPage demoQAPage = new DemoQAPage();

        ElementsPage elementsPage = new ElementsPage();

        JavascriptExecutor executor = (JavascriptExecutor) driver();
        executor.executeScript("arguments[0].click();", demoQAPage.getElementsPage());

        elementsPage.getRadioButtonNav().click();
        getWait().until(ExpectedConditions.visibilityOf(elementsPage.getRadioButtonYes()));
        elementsPage.getRadioButtonYes().click();

        elementsPage.getWebTablesNav().click();
        getWait().until(ExpectedConditions.visibilityOf(elementsPage.getSearchField()));
        elementsPage.getSearchField().sendKeys("Cierra");
        getWait().until(ExpectedConditions.visibilityOf(elementsPage.getAssertSearchData()));
        waitForSeconds(5);
    }

    @Test
    void practiseForm(){

        DemoQAPage demoQAPage = new DemoQAPage();

        ElementsPage elementsPage = new ElementsPage();

        JavascriptExecutor executor = (JavascriptExecutor) driver();
        executor.executeScript("arguments[0].click();", demoQAPage.getElementsPage());

        elementsPage.getTextBoxtNav().click();

        elementsPage.getUsernameInput().sendKeys(randomData("test"));
        elementsPage.getEmailInput().sendKeys(randomData("@email.ee"));
        elementsPage.getCurrentAddress().sendKeys(randomData("currentAddress"));
        elementsPage.getPernamentAddress().sendKeys(randomData("pernamentAddress"));
        elementsPage.getSubmitButton().click();

        waitForSeconds(5);
    }
}

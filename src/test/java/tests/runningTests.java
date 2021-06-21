package tests;

import configurations.BaseTest;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import pages.DemoQAPage;
import pages.ElementsPage;

public class runningTests extends BaseTest {


    @Test
    void demoQAPractise() {


        DemoQAPage demoQAPage = new DemoQAPage();

        ElementsPage elementsPage = new ElementsPage();

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", demoQAPage.getElementsPage());

        elementsPage.getRadioButtonNav().click();
        getWait.until(ExpectedConditions.visibilityOf(elementsPage.getRadioButtonYes()));
        elementsPage.getRadioButtonYes().click();

        elementsPage.getWebTablesNav().click();
        getWait.until(ExpectedConditions.visibilityOf(elementsPage.getSearchField()));
        elementsPage.getSearchField().sendKeys("Cierra");
        getWait.until(ExpectedConditions.visibilityOf(elementsPage.getAssertSearchData()));
        waitForSeconds(5);
    }

    @Test
    void practiseForm() {

        DemoQAPage demoQAPage = new DemoQAPage();

        ElementsPage elementsPage = new ElementsPage();

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", demoQAPage.getElementsPage());

        elementsPage.getTextBoxtNav().click();

        elementsPage.pillPage(randomData("dd"), randomData("ee"));

        waitForSeconds(5);
        elementsPage.getCurrentAddress().sendKeys(randomData("currentAddress"));
        elementsPage.getPernamentAddress().sendKeys(randomData("pernamentAddress"));
        elementsPage.getSubmitButton().click();

        waitForSeconds(5);
    }

    @Test
    void testDropdown() {

        ElementsPage elementsPage = new ElementsPage();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", elementsPage.getClickDropDown());
        elementsPage.getClickDropDown().click();

        selectRandomValueFromDropDown(elementsPage.getClickDropDown(), elementsPage.getDropDownValues());
        System.out.println(selectRandomValueFromDropDown(elementsPage.getClickDropDown(), elementsPage.getDropDownValues()));

    }
}

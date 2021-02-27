package tests;

import configurations.BaseTest;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DemoQAPage;
import pages.ElementsPage;

public class runningTests extends BaseTest {

    @Test
    void demoQAPractise(){

        DemoQAPage demoQAPage = new DemoQAPage();

        getWait().until(ExpectedConditions.visibilityOf(demoQAPage.getFooter()));

        JavascriptExecutor  executor = (JavascriptExecutor )driver();
        executor.executeScript("arguments[0].click();", demoQAPage.getElementsPage());

        ElementsPage elementsPage = new ElementsPage();

        getWait().until(ExpectedConditions.visibilityOf(elementsPage.getElementsPageText()));
        elementsPage.getTextBoxtNav().click();


        elementsPage.getUsernameInput().sendKeys("testUser");
        elementsPage.getEmailInput().sendKeys("test@email.ee");
        elementsPage.getCurrentAddress().sendKeys("currentAddress");
        elementsPage.getPernamentAddress().sendKeys("pernamentAddress");
        elementsPage.getSubmitButton().click();
        getWait().until(ExpectedConditions.visibilityOf(elementsPage.getOutPutData()));

        Assert.assertTrue(elementsPage.getOutPutData().getText().contains("currentAddress"));
        Assert.assertTrue(elementsPage.getOutPutData().getText().contains("pernamentAddress"));

        elementsPage.getRadioButtonNav().click();
        getWait().until(ExpectedConditions.visibilityOf(elementsPage.getRadioButtonYes()));
        elementsPage.getRadioButtonYes().click();

        elementsPage.getWebTablesNav().click();
        getWait().until(ExpectedConditions.visibilityOf(elementsPage.getSearchField()));
        elementsPage.getSearchField().sendKeys("Cierra");
        getWait().until(ExpectedConditions.visibilityOf(elementsPage.getAssertSearchData()));
        waitForSeconds(5);

    }
}

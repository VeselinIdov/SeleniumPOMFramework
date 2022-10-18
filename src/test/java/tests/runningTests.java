package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.TestListenerAdapter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;

@Listeners(TestListenerAdapter.class)
public class runningTests extends BaseTest {

    @Severity(SeverityLevel.BLOCKER)
    @Description("some test desciption of test")
    @Test
    void testDropdown() throws Exception {
        HomePage homePage = new HomePage();
        homePage.clickOnElement();
        homePage.getText();
        System.out.println( Thread.currentThread().getId());


    }

    @Test
    void testDropdown1() {
        HomePage homePage = new HomePage();
        homePage.clickOnElement();
        System.out.println( Thread.currentThread().getId());

    }
}
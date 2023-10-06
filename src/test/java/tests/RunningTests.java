package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.TestListenerAdapter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;

@Listeners(TestListenerAdapter.class)
public class RunningTests extends BaseTest {

    @Severity(SeverityLevel.BLOCKER)
    @Description("some description of test")
    @Test
    void testDropdown() {
        HomePage homePage = new HomePage();
        homePage.enterUsername("test");
        homePage.clickOnLoginButton();
    }
}
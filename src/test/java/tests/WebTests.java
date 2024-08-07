package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import web.base.BaseTest;
import web.pages.HomePage;

public class WebTests extends BaseTest {

        @Severity(SeverityLevel.BLOCKER)
        @Description("some description of test")
        @Test
        void loginAsUserTest() {
            System.out.println(Thread.currentThread().getId());
            HomePage homePage = new HomePage();
            homePage.loginAsUser("standard_user", "secret_sauce");
        }

    @Severity(SeverityLevel.MINOR)
    @Description("some  descriptionsome descriptionsome descriptionsome description")
    @Test
    public void clickActionsExamples() {
        System.out.println(System.nanoTime());
    }
}
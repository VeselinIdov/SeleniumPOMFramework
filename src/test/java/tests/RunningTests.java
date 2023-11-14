package tests;

import api.requests.EmployeeRequests;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;
import org.testng.TestListenerAdapter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import web.utils.BaseTest;
import web.pages.HomePage;


@Listeners(TestListenerAdapter.class)
public class RunningTests extends BaseTest {

    @Severity(SeverityLevel.BLOCKER)
    @Description("some description of test")
    @Test
    void loginAsUserTest() {
        System.out.println(Thread.currentThread().getId());
        HomePage homePage = new HomePage();
        homePage.loginAsUser("standard_user", "secret_sauce");
    }

    @Severity(SeverityLevel.BLOCKER)
    @Description("some description of test")
    @Test
    void loginAsUserTest1() {
        Response response = new EmployeeRequests().getAllEmployee();
    }
}
package tests;

import api.pojo.EmployeeRequestPayload;
import api.pojo.EmployeeResponseBody;
import api.requests.EmployeeRequests;
import core.utils.JSONUtils;
import enums.StatusCode;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class APITests {

    @Severity(SeverityLevel.MINOR)
    @Description("some description of test")
    @Test
    void getEmployeeTest() {
        Response response = new EmployeeRequests().getEmployees();
        Assert.assertEquals(response.statusCode(), StatusCode.SUCCESS.getValue());
        EmployeeResponseBody responseBody = JSONUtils.deserializeResponse(response.asPrettyString(), EmployeeResponseBody.class);
        System.out.println(response.statusCode());
        System.out.println(responseBody.getMessage());
        System.out.println(responseBody.getStatus());
        System.out.println(responseBody.getData().getName());
    }

    @Test
    public void CreateEmployeeTest() {
        EmployeeRequestPayload employeeRequestPayload = new EmployeeRequestPayload();
        employeeRequestPayload.setAge("15");
        employeeRequestPayload.setName("test");
        employeeRequestPayload.setSalary("1234");
        Response response = new EmployeeRequests().createEmployee(employeeRequestPayload);
    }
}
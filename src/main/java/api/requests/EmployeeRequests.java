package api.requests;
import api.BaseRequest;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.response.Response;


public class EmployeeRequests extends BaseRequest {
    Faker faker = new Faker();
    private static final String CREATE_EMPLOYEE_PATH = "create";
    private static final String GET_EMPLOYEE_PATH = "employees";

    public Response getAllEmployee() {
        return RestAssured
                .given(getRequestSpec())
                .get(GET_EMPLOYEE_PATH);
    }

    public Response createEmployee() {

        return RestAssured.given(getRequestSpec())
                .body("")
                .post(CREATE_EMPLOYEE_PATH);
    }
}
package api.requests;

import api.base.BaseRequest;
import api.pojo.EmployeeRequestPayload;
import io.restassured.response.Response;

public class EmployeeRequests extends BaseRequest {

    private static final String CREATE_EMPLOYEE_PATH = "create";
    private static final String GET_EMPLOYEE_PATH = "employees";
    private static final String GET_EMPLOYEE_PATH_WITH_PARAM = "employee";
    private static final String UPDATE_EMPLOYEE_PATH_WITH_PARAM = "update/{id}";
    private static final String DELETE_EMPLOYEE_PATH_WITH_PARAM = "delete/{id}";

    public Response getEmployees() {
        return this.getRequest(GET_EMPLOYEE_PATH);
    }

    public Response getEmployeeById(String id) {
        return this.getRequest(GET_EMPLOYEE_PATH_WITH_PARAM + "/{id}", id);
    }

    public Response createEmployee(EmployeeRequestPayload employeeRequestBody) {
        return this.postRequest(CREATE_EMPLOYEE_PATH, employeeRequestBody);
    }

    public Response updateEmployee(EmployeeRequestPayload employeeRequestBody, String id) {
        return this.putRequest(UPDATE_EMPLOYEE_PATH_WITH_PARAM, employeeRequestBody, id);
    }

    public Response deleteEmployeeById(String id) {
        return this.deleteRequest(DELETE_EMPLOYEE_PATH_WITH_PARAM, id);
    }
}
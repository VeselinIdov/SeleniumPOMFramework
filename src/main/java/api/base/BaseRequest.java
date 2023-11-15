package api.base;

import core.configurations.ConfigurationManager;
import core.utils.LogUtils;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseRequest {

    private static final String BASE_URL = ConfigurationManager.configuration().getApiURL();

    public RequestSpecification getRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .setContentType(ContentType.JSON)
                .build().log().all();
    }

    public Response getRequest(String path, String param) {
        Response response = RestAssured
                .given(getRequestSpec())
                .pathParams("id", param)
                .get(path);
        LogUtils.LOGGER.info("Send GET request to: " + BASE_URL + path + param);
        return response;
    }

    public Response getRequest(String url) {
        Response response = RestAssured
                .given(getRequestSpec())
                .get(url);
        LogUtils.LOGGER.info("Send GET request to: " + BASE_URL + url);
        return response;
    }

    public Response postRequest(String path, Object object) {
        Response response = RestAssured
                .given(getRequestSpec())
                .body(object)
                .post(path);
        LogUtils.LOGGER.info("Send POST request to: " + BASE_URL + path);
        return response;
    }

    public Response postRequest(String path, Object object, String param) {
        Response response = RestAssured
                .given(getRequestSpec())
                .pathParams("id", param)
                .body(object)
                .post(path);
        LogUtils.LOGGER.info("Send POST request to: " + BASE_URL + path + param);
        return response;
    }

    public Response patchRequest(String path, Object object, String param) {
        Response response = RestAssured
                .given(getRequestSpec())
                .pathParams("id", param)
                .body(object)
                .patch(path);
        LogUtils.LOGGER.info("Send PATCH request to: " + BASE_URL + path + param);
        return response;
    }

    public Response putRequest(String path, Object object, String param) {
        Response response = RestAssured
                .given(getRequestSpec())
                .pathParams("id", param)
                .body(object)
                .put(path);
        LogUtils.LOGGER.info("Send PUT request to: " + BASE_URL + path + param);
        return response;
    }

    public Response deleteRequest(String path, String param) {
        Response response = RestAssured
                .given(getRequestSpec())
                .pathParams("id", param)
                .delete(path);
        LogUtils.LOGGER.info("Send DELETE request to: "+ BASE_URL + path + param);
        return response;
    }
}
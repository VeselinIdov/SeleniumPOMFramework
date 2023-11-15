package api.base;

import core.configurations.ConfigurationManager;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseRequest {

    public RequestSpecification getRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(ConfigurationManager.configuration().getApiURL())
                .setContentType(ContentType.JSON)
                .build().log().all();
    }

    public Response getRequest(String path, String param) {
        return RestAssured
                .given(getRequestSpec())
                .pathParams("id", param)
                .get(path);
    }

    public Response getRequest(String url) {
        return RestAssured
                .given(getRequestSpec())
                .get(url);
    }

    public Response postRequest(String path, Object object) {
        return RestAssured
                .given(getRequestSpec())
                .body(object)
                .post(path);
    }

    public Response postRequest(String path, Object object, String param) {
        return RestAssured
                .given(getRequestSpec())
                .pathParams("id", param)
                .body(object)
                .post(path);
    }

    public Response patchRequest(String path, Object object, String param) {
        return RestAssured
                .given(getRequestSpec())
                .pathParams("id", param)
                .body(object)
                .patch(path);
    }

    public Response putRequest(String path, Object object, String param) {
        return RestAssured
                .given(getRequestSpec())
                .pathParams("id", param)
                .body(object)
                .put(path);
    }

    public Response deleteRequest(String path, String param) {
        return RestAssured
                .given(getRequestSpec())
                .pathParams("id", param)
                .delete(path);
    }
}
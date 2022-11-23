package api;

import api.apiutils.EndpointPaths;
import com.google.gson.Gson;
import configurations.config.ConfigurationManager;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;

public class BaseRequests {

    public RequestSpecification requestSpecifications() {

        return new RequestSpecBuilder().setBaseUri(ConfigurationManager.configuration().getApiURL())
                .setContentType(ContentType.JSON).build();
    }

    public Response listUsers() {
        return given().log().all()
                .spec(requestSpecifications())
                .contentType(ContentType.JSON)
                .when().get(EndpointPaths.getListUsersPath())
                .then()
                .and().assertThat().statusCode(200).log().all()
                .extract().response();
    }

    public Response getUsers(int id) {
        return given().log().all()
                .spec(requestSpecifications())
                .contentType(ContentType.JSON)
                .when().get("/api/users/" + id + "")
                .then()
                .and().assertThat().statusCode(200).log().all()
                .extract().response();
    }

    @Test
    public void testName() {
        getUsers(7);
    }
}

package tests.api;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RestAssuredSimpleTest {

    @Test
    public void simpleStepByStepGetApiTest() {
        // Set up Rest Assured
        RestAssured.baseURI = "https://reqres.in/";

        // Set up endpoint
        int userID = 2;
        String endpoint = "/api/users/" + userID;

        // Setup request object
        RequestSpecification request = given();

        //Set response and execute request
        Response response = request.request(Method.GET, endpoint);

        // Validate response
        // Get and check status code
        int statusCode = response.getStatusCode();
        System.out.println(statusCode);

        Assert.assertEquals(statusCode, HttpStatus.SC_OK);

        // Get Response Body
        String responseBody = response.getBody().asString();
        System.out.println(responseBody);
        System.out.println(response.getBody().prettyPrint());
    }

    @Test
    public void simpleShortGetApiTest() {
        // Set up Rest Assured
        RestAssured.baseURI = "https://reqres.in/";

        // Set up endpoint
        int userID = 2;
        String endpoint = "/api/users/" + userID;

        given()
                .when()
                .get(endpoint)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body();
    }
}
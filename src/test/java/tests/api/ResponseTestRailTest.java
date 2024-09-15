package tests.api;

import baseEntities.BaseApiTest;
import io.restassured.response.Response;
import models.User;
import models.Users;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class ResponseTestRailTest extends BaseApiTest {
    String name;

    @Test
    public void getAllProjectsTest() {
        String endpoint = "/index.php?/api/v2/get_projects";
        given()
                .when()
                .get(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .body("limit", is(250))
                .body("size", is(15));
    }

    @Test
    public void getSingleValueTest() {
        int projectId = 37;
        String endpoint = "/index.php?/api/v2/get_project/" + projectId;

        name = given()
                .when()
                .get(endpoint)
                .then()
                .log().body()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract().jsonPath().getString("name");

        System.out.println(name);
    }

    @Test
    public void getResponseValueTest() {
        int projectId = 37;
        String endpoint = "/index.php?/api/v2/get_project/" + projectId;

        Response response = given()
                .when()
                .get(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();

        Assert.assertEquals(response.getBody().jsonPath().getString("name"), "Incredible Bronze Table");
    }

    @Test
    public void paramTest() {
        int projectId = 37;
        String endpoint = "/index.php?/api/v2/get_project/{project_id}";

        name = given()
                .pathParams("project_id", projectId)
                .when()
                .get(endpoint)
                .then()
                .log().body()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract().jsonPath().getString("name");

        System.out.println(name);
    }

    @Test
    public void getAllUsersAsArrayTest() {
        Response response = userService.getUsers();

        User[] users = response.getBody().jsonPath().getObject("users", User[].class);

        System.out.println(users[0]);
        System.out.println(users.length);
    }

    @Test
    public void getAllUsersAsObjectTest() {
        Response response = userService.getUsers();

        Users users = response.getBody().as(Users.class);

        System.out.println(users);
        System.out.println(users.getUsers()[0]);
        System.out.println(users.getUsers()[1]);
    }

    @Test
    public void getAllUsersAsListTest() {
        Response response = userService.getUsers();
        List<User> usersList = response.getBody().jsonPath().getList("users");

        System.out.println(usersList.get(0));
    }
}
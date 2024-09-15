package baseEntities;

import configuration.ReadProperties;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.protocol.HTTP;
import org.testng.annotations.BeforeTest;
import services.ProjectService;
import services.UserService;

import static io.restassured.RestAssured.given;

public class BaseApiTest {
    protected ProjectService projectService;
    protected UserService userService;

    @BeforeTest
    public void setUpApiClient() {
        // Set up Rest Assured
        RestAssured.baseURI = ReadProperties.getUri();

        //Update default Request Specification

        RestAssured.requestSpecification = given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .auth().preemptive().basic(ReadProperties.username(), ReadProperties.password());

        projectService = new ProjectService();
        userService = new UserService();
    }
}
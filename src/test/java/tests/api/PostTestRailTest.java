package tests.api;

import baseEntities.BaseApiTest;
import io.restassured.mapper.ObjectMapperType;
import models.Project;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class PostTestRailTest extends BaseApiTest {

    @Test
    public void addProjectUsingStringTest() {
        String endpoint = "/index.php?/api/v2/add_project";

        Project expectedProject = new Project();
        expectedProject.setName("WP_Project_01");
        expectedProject.setAnnouncement("This is a test announcement.");
        expectedProject.setShowAnnouncement(true);
        expectedProject.setSuiteMode(2);

        given()
                .body(String.format("{\n" +
                                "    \"name\": \"%s\",\n" +
                                "    \"announcement\": \"%s\",\n" +
                                "    \"show_announcement\": %b,\n" +
                                "    \"suite_mode\": %d\n" +
                                "}",
                        expectedProject.getName(),
                        expectedProject.getAnnouncement(),
                        expectedProject.isShowAnnouncement(),
                        expectedProject.getSuiteMode()))
                .when()
                .post(endpoint)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body();
    }

    @Test
    public void addProjectUsingMapTest() {
        String endpoint = "/index.php?/api/v2/add_project";

        Project expectedProject = new Project();
        expectedProject.setName("WP_Project_02");
        expectedProject.setAnnouncement("This is a test announcement2.");
        expectedProject.setShowAnnouncement(false);
        expectedProject.setSuiteMode(3);

        Map<String, Object> jsonAsMap = new HashMap<String, Object>();
        jsonAsMap.put("name", expectedProject.getName());
        jsonAsMap.put("suite_mode", expectedProject.getSuiteMode());

        given()
                .body(jsonAsMap)
                .when()
                .post(endpoint)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body();
    }

    @Test
    public void addProjectUsingObjectTest() {  //Сериализация и десериализация
        String endpoint = "/index.php?/api/v2/add_project";

        Project expectedProject = new Project();
        expectedProject.setName("WP_Project_02");
        expectedProject.setAnnouncement("This is a test announcement2.");
        expectedProject.setShowAnnouncement(false);
        expectedProject.setSuiteMode(1);

        given()
                .body(expectedProject, ObjectMapperType.GSON)
                .log().body()
                .when()
                .post(endpoint)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body();
    }

    @Test
    public void addProjectUsingFileTest() {
        String endpoint = "/index.php?/api/v2/add_project";

        given()
                .body(PostTestRailTest.class.getClassLoader().getResourceAsStream("tmp.json"))
                .when()
                .post(endpoint)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body();




        // этим не пользуются, просто пусть будет

       /* Gson gson = new Gson();
        String json = gson.toJson(expectedProject); // сериализация
        System.out.println(json);

        Project actualProject = gson.fromJson(json, Project.class); // десериализация
        System.out.println(actualProject.toString());

        Assert.assertEquals(actualProject.getName(), expectedProject.getName());

        Reader reader = new FileReader(PostTestRailTest.class.getClassLoader().getResource("tmp.json").getFile());
        gson.fromJson(reader, Project.class); // вычитка из файла */
    }
}
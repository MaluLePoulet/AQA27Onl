package services;

import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.Project;
import org.apache.http.HttpStatus;
import utils.Endpoints;

import static io.restassured.RestAssured.given;

public class ProjectService implements IProjectService {
    @Override
    public Response getGeneralProject(int projectId) { //для негативных сценариев
        //Response response = given()
        return given()
                .pathParam("project_id", projectId)
                .log().all()
                .when()
                .get(Endpoints.GET_PROJECT)
                .then()
                .log().body()
                .extract().response();
    }

    @Override
    public Project getProject(int projectId) { // для выполнения позитивных сценариев, когда мы точно знаем, что такой проект есть
        return given()
                .pathParam("project_id", projectId)
                .log().all()
                .when()
                .get(Endpoints.GET_PROJECT)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(Project.class, ObjectMapperType.GSON);
    }

    @Override
    public void getProjects() {

    }

    @Override
    public Project addProject(Project project) {
        return given()
                .body(project)
                .log().body()
                .when()
                .post(Endpoints.ADD_PROJECT)
                .then()
                .log().body()
                .extract().as(Project.class, ObjectMapperType.GSON);

    }

    @Override
    public Project updateProject(Project project) {
        return null;
    }

    @Override
    public Response deleteProject(int projectId) {
        return null;
    }
}
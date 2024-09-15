package services;

import io.restassured.response.Response;
import models.Project;

public interface IProjectService {

    Response getGeneralProject(int projectId);

    Project getProject(int projectId);

    void getProjects();

    Project addProject(Project project);

    Project updateProject(Project project);

    Response deleteProject(int projectId);
}
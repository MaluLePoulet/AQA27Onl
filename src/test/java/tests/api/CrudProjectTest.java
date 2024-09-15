package tests.api;

import baseEntities.BaseApiTest;
import io.restassured.response.Response;
import models.Project;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.is;

public class CrudProjectTest extends BaseApiTest {
    private Project actualProject;

    @Test
    public void addProjectTest() {
        Project expectedProject = new Project();
        expectedProject.setName("Test API Project");
        expectedProject.setAnnouncement("Pipipi");
        expectedProject.setShowAnnouncement(true);
        expectedProject.setSuiteMode(2);

        actualProject = projectService.addProject(expectedProject);

        System.out.println(actualProject);
        Assert.assertEquals(actualProject.getName(), expectedProject.getName());
        Assert.assertEquals(actualProject.getAnnouncement(), expectedProject.getAnnouncement());
        Assert.assertEquals(actualProject, expectedProject);
    }

    @Test(dependsOnMethods = "addProjectTest")
    public void readProjectTest() {
        Project project = projectService.getProject(actualProject.getId());

        System.out.println(project);
        Assert.assertEquals(project, actualProject);
    }

    @Test
    public void readProjectTest1() {
        Response response = projectService.getGeneralProject(251);

        response
                .then()
                .assertThat()
                .statusCode(400)
                .body("error", is("Field :project_id is not a valid or accessible project."));
    }

    @Test
    public void updateProjectTest() {

    }

    @Test
    public void deleteProjectTest() {

    }
}

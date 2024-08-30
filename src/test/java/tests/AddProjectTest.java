package tests;

import baseEntities.BaseTest;
import models.Project;
import org.testng.annotations.Test;

public class AddProjectTest extends BaseTest {

    @Test
    public void addProjectTest() {
        Project project = new Project();
        project.setName("adad");
        project.setAnnouncement("sajdja");

        projectSteps.addProject(project);

        System.out.println(project);
    }

}

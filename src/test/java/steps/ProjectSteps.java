package steps;

import baseEntities.BaseStep;
import models.Project;
import org.openqa.selenium.WebDriver;
import pages.projects.AddProjectPage;

public class ProjectSteps extends BaseStep{

    public ProjectSteps(WebDriver driver) {
        super(driver);
    }

    public void addProject(Project project) {
        AddProjectPage addProjectPage = new AddProjectPage(driver);
        addProjectPage.setProjectName(project.getName());

        System.out.println(project.getId());
    }

    public void editProject(String projectName) {

    }

    public void searchProject(String projectName) {

    }

    public void deleteProject(String projectName) {

    }


}

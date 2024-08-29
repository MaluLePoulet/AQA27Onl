package steps;

import baseEntities.BaseStep;
import models.Project;
import org.openqa.selenium.WebDriver;
import pages.administration.ProjectsPage;
import pages.projects.AddProjectPage;

public class ProjectSteps extends BaseStep{

    public ProjectSteps(WebDriver driver) {
        super(driver);
    }

    public ProjectsPage addProject(Project project) {
        AddProjectPage addProjectPage = new AddProjectPage(driver);
        addProjectPage
                .setNameInput(project.getName())
                .setAnnouncementInput(project.getAnnouncement())
                .setShowAnnouncementCheckbox(project.isShowAnnouncementFlag())
                .selectProjectTypeByIndex(project.getProjectType())
                .setTCApprovalsCheckbox(project.isTCApprovalsEnabled())
                .addProjectPage()
                .clickSaveProjectButton();

        return projectsPage;
    }

    public void editProject(String projectName) {

    }

    public void searchProject(String projectName) {

    }

    public void deleteProject(String projectName) {

    }
}
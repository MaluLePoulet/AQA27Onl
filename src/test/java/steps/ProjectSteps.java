package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.administration.ProjectsPage;

public class ProjectSteps extends BaseStep {

    public ProjectSteps(WebDriver driver) {
        super(driver);
    }

    /**
     *
     * @param projectName
     * @param announcement
     * @param showAnnouncementFlag
     * @param projectTypeNumber
     * @param tcApprovalsFlag
     */
    public ProjectsPage addProject(String projectName, String announcement, boolean showAnnouncementFlag, int projectTypeNumber, boolean tcApprovalsFlag) {
        dashboardPage.sideMenuPage.clickAddProjectButton()
                .setNameInput(projectName)
                .setAnnouncementInput(announcement)
                .setShowAnnouncementCheckbox(showAnnouncementFlag)
                .selectProjectTypeByIndex(projectTypeNumber)
                .setTCApprovalsCheckbox(tcApprovalsFlag)
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

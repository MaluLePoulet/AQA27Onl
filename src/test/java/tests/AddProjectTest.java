package tests;

import baseEntities.BaseTest;
import models.Project;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.menus.SideMenuPage;

public class AddProjectTest extends BaseTest {

    @Test
    public void addProjectTest() {
        Project project = new Project();
        project.setName(faker.commerce().productName());
        project.setAnnouncement(faker.backToTheFuture().quote());
        project.setShowAnnouncementFlag(faker.bool().bool());
        project.setProjectType(faker.number().numberBetween(0, 3));
        project.setEnableTCApprovals(faker.bool().bool());

        SideMenuPage sideMenuPage = new SideMenuPage(driver);
        sideMenuPage.clickAddProjectButton();

        Assert.assertTrue(projectSteps.addProject(project).getSuccessMessageElement().isDisplayed());
    }
}
package tests;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProjectTest extends BaseTest {

    @Test
    public void addProjectTest() {
        String projectName = faker.company().name();
        String announcement = faker.friends().quote();
        boolean showAnnouncementFlag = faker.bool().bool();
        int projectTypeNumber = faker.number().numberBetween(0, 3);
        boolean tcApprovalsFLag = faker.bool().bool();

        Assert.assertEquals(projectSteps
                .addProject(projectName,
                        announcement,
                        showAnnouncementFlag,
                        projectTypeNumber,
                        tcApprovalsFLag)

                .getProjectsList()
                .getCell("Project", projectName, 0)
                .getAsUIElement()
                .getText(), projectName);
    }
}

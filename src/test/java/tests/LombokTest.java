package tests;

import models.Milestone;
import models.Project;
import models.TestCase;
import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LombokTest {

    @Test
    public void lombokUserTest() {
        User actualUser = new User();
        actualUser.setId(1);
        actualUser.setUsername("Username");
        actualUser.setPassword("Password");
        System.out.println(actualUser);

        User expectedlUser = new User();
        expectedlUser.setUsername("Username");
        expectedlUser.setPassword("Password");
        System.out.println(expectedlUser);

        System.out.println(actualUser);
        System.out.println(expectedlUser.hashCode());

        Assert.assertEquals(actualUser, expectedlUser);
    }

    @Test
    public void lombokProjectTest() {
        Project actualProject = new Project();
        actualProject.setId(1);
        actualProject.setName("Project Name");
        actualProject.setAnnouncement("Announcement");
        actualProject.setProjectType(2);
        actualProject.setTCApprovalsEnabled(true);
        System.out.println(actualProject);

        Project expectedProject = new Project();
        expectedProject.setName("Project Name");
        expectedProject.setAnnouncement("Announcement");
        expectedProject.setProjectType(2);
        expectedProject.setTCApprovalsEnabled(true);
        System.out.println(expectedProject);

        System.out.println(actualProject.hashCode());
        System.out.println(expectedProject.hashCode());

        Assert.assertNotEquals(actualProject, expectedProject);
    }

    @Test
    public void lombokTestCaseTest() {
        /*TestCase actualTestCase = TestCase.Director.getActualTestCase(); // Спросить можно ли так делать
        TestCase expectedTestCase = TestCase.Director.getExpectedTestCase();

        System.out.println(actualTestCase);
        System.out.println(expectedTestCase);

        Assert.assertEquals(actualTestCase,expectedTestCase);
    }*/

        TestCase actualTestCase = TestCase.builder()
                .title("Test Case")
                .section("Test Cases")
                .template("Test Case(Steps)")
                .type("Other")
                .priority("Medium")
                .preconditions("Preconditions")
                .expectedResults("Expected results")
                .build();

        TestCase expectedTestCase = actualTestCase.toBuilder().build();

        System.out.println(actualTestCase);
        System.out.println(expectedTestCase);

        Assert.assertEquals(actualTestCase, expectedTestCase);
    }

    @Test
    public void lombokMilestonesTest() {
        Milestone actualMilestone =
                new Milestone(1,
                        "Milestone",
                        "Reference",
                        "Description",
                        true);
        System.out.println(actualMilestone);

        Milestone expectedMilestone =
                new Milestone(
                        "Milestone",
                        "Reference",
                        "Description",
                        true);
        System.out.println(expectedMilestone);

        System.out.println(actualMilestone.hashCode());
        System.out.println(expectedMilestone.hashCode());

        Assert.assertEquals(actualMilestone, expectedMilestone);
    }
}
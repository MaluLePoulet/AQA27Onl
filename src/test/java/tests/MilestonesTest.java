package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.overview.ProjectsPage;
import utils.Director;

import java.time.Duration;
import java.util.List;

public class MilestonesTest extends BaseTest {

    @Test
    public void milestonesTest() {
        ProjectsPage projectsPage = new ProjectsPage(driver);
        driver.get("https://aqa27onl2.testrail.io/index.php?/admin/projects/overview");

        Actions actions = new Actions(driver);

        List<WebElement> targetElements = waitsService.visibilityOfAllElementsLocatedBy(By.cssSelector(".odd.hoverSensitive"));

        actions
                .moveToElement(targetElements.get(0))
                .click(waitsService.presenceOfElementLocated(By.className("icon-small-openswindow")))
                .build()
                .perform();


        projectsPage.sideMenuPage.clickAddMilestoneButton();

        Assert.assertTrue(milestoneSteps.createMilestone(Director.getRandomMilestone()).isMilestoneCreated());
    }
}
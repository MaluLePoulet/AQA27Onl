package stepsDefs;

import baseEntities.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.DashboardPage;
import pages.projects.AddProjectPage;

public class ProjectsStepDefs extends BaseTest {
    private BaseTest baseTest;

    DashboardPage dashboardPage;

    public ProjectsStepDefs(BaseTest baseTest) {
        this.baseTest = baseTest;
    }

    @Given("aerodynamic rubber car project is open")
    public void clickOnProjectName() {
        dashboardPage = new DashboardPage(baseTest.driver);
        dashboardPage.clickProjectNameButton();
    }

    @When("user clicks add project button")
    public void userClicksAddProjectButton() {
        dashboardPage = new DashboardPage(baseTest.driver);
        dashboardPage.sideMenuPage.clickAddProjectButton();
    }

    @Then("add project page is displayed")
    public void addProjectPageIsDisplayed() {
        Assert.assertTrue(new AddProjectPage(baseTest.driver).isPageOpen());
    }
}

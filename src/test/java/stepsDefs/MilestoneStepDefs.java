package stepsDefs;

import baseEntities.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.AddMilestonePage;
import pages.instances.MilestoneInstancePage;
import pages.menus.SideMenuPage;
import pages.overview.MilestonesPage;

public class MilestoneStepDefs extends BaseTest {
    BaseTest baseTest;

    SideMenuPage sideMenuPage;
    AddMilestonePage addMilestonePage;
    MilestonesPage milestonesPage;
    MilestoneInstancePage milestoneInstancePage;

    public MilestoneStepDefs(BaseTest baseTest) {
        this.baseTest = baseTest;
    }

    @When("user clicks add milestone button on the sidebar")
    public void clickAddMilestone() {
        sideMenuPage = new SideMenuPage(baseTest.driver);
        sideMenuPage.clickAddMilestoneButton();
    }

    @When("user sets name {string}")
    public void setName(String milestoneName) {
        addMilestonePage = new AddMilestonePage(baseTest.driver);
        addMilestonePage.setNameInput(milestoneName);
    }

    @When("user sets references {string}")
    public void setReferences(String references) {
        addMilestonePage.setReferencesInput(references);
    }

    @When("user sets description {string}")
    public void setDescription(String description) {
        addMilestonePage.setDescriptionInput(description);
    }

    @When("user removes milestone completed checkbox")
    public void removeMilestoneCompletedCheckbox() {
        addMilestonePage.getMilestoneCompletedCheckbox().remove();
    }

    @When("user clicks save milestone button")
    public void clickAddMilestoneButton() {
        addMilestonePage.clickAddMilestoneButton();
    }

    @When("user clicks on created milestone")
    public void clickOnMilestone() {
        milestonesPage = new MilestonesPage(baseTest.driver);
        int lastElement = milestonesPage.getActiveMilestonesList().size() - 1;
        milestonesPage
                .getActiveMilestonesList()
                .get(lastElement)
                .click();
    }

    @When("user clicks on edit milestone button")
    public void clickEditButton() {
        milestoneInstancePage = new MilestoneInstancePage(baseTest.driver);
        milestoneInstancePage.clickEditMilestoneButton();
    }

    @Given("user clicks milestone button on the top panel")
    public void clickNavigationMilestoneButton() {
        milestonesPage = new MilestonesPage(baseTest.driver);
        milestonesPage.headerMenuPage.clickNavigationMilestonesButton();
    }

    @When("user clicks delete button")
    public void userClicksDeleteButton() {
        int lastElement = milestonesPage.getDeleteIconsList().size() - 1;
        milestonesPage
                .getDeleteIconsList()
                .get(lastElement)
                .click();
    }

    @When("user clicks OK on confirmation pop up")
    public void clickConfirmDeleteButton() {
        milestonesPage.clickConfirmDeleteButton();
    }

    @When("user clicks delete milestone button and confirms deletion")
    public void clickDeleteMilestoneAndConfirm() {
        userClicksDeleteButton();
        clickConfirmDeleteButton();
    }

    @Then("add milestone page is open")
    public void isAddMilestonePageOpen() {
        addMilestonePage = new AddMilestonePage(baseTest.driver);
        Assert.assertTrue(addMilestonePage.isPageOpen());
    }

    @Then("message {string} is displayed")
    public void isMsgDisplayed(String message) {
        milestonesPage = new MilestonesPage(baseTest.driver);
        Assert.assertEquals(milestonesPage
                .getSuccessMessageElement()
                .getText(), message);
    }

    @Then("milestone with name {string} is displayed in the open milestones list")
    public void isMilestoneDisplayed(String milestoneName) {
        int lastElement = milestonesPage.getActiveMilestonesList().size() - 1;
        Assert.assertEquals(milestonesPage
                .getActiveMilestonesList()
                .get(lastElement)
                .getText(), milestoneName);
    }

    @Then("name is {string}")
    public void isName(String milestoneName) {
        addMilestonePage = new AddMilestonePage(baseTest.driver);
        Assert.assertEquals(addMilestonePage
                .getNameInput()
                .getAttribute("value"), milestoneName);
    }

    @Then("reference is {string}")
    public void isReference(String reference) {
        Assert.assertEquals(addMilestonePage
                .getReferencesInput()
                .getAttribute("value"), reference);
    }

    @Then("description is {string}")
    public void isDescription(String description) {
        Assert.assertEquals(addMilestonePage
                .getDescriptionInput()
                .getText(), description);
    }

    @Then("milestone completed checkbox is removed")
    public void isMilestoneCompletedCheckboxRemoved() {
        Assert.assertFalse(addMilestonePage
                .getMilestoneCompletedCheckbox().isCheckboxSet());
    }
}
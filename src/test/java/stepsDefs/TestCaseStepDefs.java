package stepsDefs;

import baseEntities.BaseTest;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.AddTestCasePage;
import pages.instances.TestCaseInstancePage;
import pages.menus.SideMenuPage;

import java.util.Map;

public class TestCaseStepDefs extends BaseTest {
    BaseTest baseTest;

    SideMenuPage sideMenuPage;
    AddTestCasePage addTestCasePage;
    TestCaseInstancePage testCaseInstancePage;

    public TestCaseStepDefs(BaseTest baseTest) {
        this.baseTest = baseTest;
    }

    @When("user clicks add test case button")
    public void clickAddTCButton() {
        sideMenuPage = new SideMenuPage(baseTest.driver);
        sideMenuPage.clickAddTCButton();
    }

    @When("user clicks edit test case button")
    public void clickEditTCButton() {
        testCaseInstancePage.clickEditButton();
    }

    @When("user clicks delete this test case button")
    public void clickDeleteTCButton() {
        sideMenuPage.clickDeleteTCButton();
    }

    @When("user clicks delete permanently button")
    public void confirmTCDeletion() {
        testCaseInstancePage.clickDeletePermanentlyTCButton();
        testCaseInstancePage.clickDeletePermanentlyTCSecondButton();
    }

    @When("user clicks delete button and confirms deletion")
    public void clickTCDeleteAndConfirm() {
        clickDeleteTCButton();
        confirmTCDeletion();
    }

    @When("user creates test case with")
    public void createTCWith(DataTable parameters) {
        Map<String, String> expectedValues = parameters.asMap(String.class, String.class);
        addTestCasePage.setTitleInput(expectedValues.get("title"));
        addTestCasePage.getTemplateDropDown().selectByText(expectedValues.get("template"));
        addTestCasePage.getTypeDropDown().selectByText(expectedValues.get("type"));
        addTestCasePage.getPriorityDropDown().selectByText(expectedValues.get("priority"));
        addTestCasePage.getAutomationTypeDropDown().selectByText(expectedValues.get("automation type"));
        addTestCasePage.setPreconditionsInput(expectedValues.get("preconditions"));
        addTestCasePage.setStepsInput(expectedValues.get("steps"));
        addTestCasePage.clickSaveTCButton();
    }

    @When("user updates test case to")
    public void updateTC(DataTable parameters) {
        Map<String, String> expectedValues = parameters.asMap(String.class, String.class);
        addTestCasePage.setTitleInput(expectedValues.get("title"));
        addTestCasePage.getTemplateDropDown().selectByText(expectedValues.get("template"));
        addTestCasePage.getTypeDropDown().selectByText(expectedValues.get("type"));
        addTestCasePage.getPriorityDropDown().selectByText(expectedValues.get("priority"));
        addTestCasePage.getAutomationTypeDropDown().selectByText(expectedValues.get("automation type"));
        addTestCasePage.setPreconditionsInput(expectedValues.get("preconditions"));
        addTestCasePage.setStepsInput(expectedValues.get("steps"));
        addTestCasePage.clickSaveTCButton();
    }

    @Then("add test case page is open")
    public void isAddTCPageOpen() {
        addTestCasePage = new AddTestCasePage(baseTest.driver);
        Assert.assertTrue(addTestCasePage.isPageOpen());
    }

    @Then("created test case page is open")
    public void isTestCasePageOpen() {
        testCaseInstancePage = new TestCaseInstancePage(baseTest.driver);
        Assert.assertTrue(testCaseInstancePage.isPageOpen());
    }

    @Then("created test case is")
    public void isCreatedTC(DataTable parameters) {
        Map<String, String> expectedValues = parameters.asMap(String.class, String.class);
        Assert.assertEquals(addTestCasePage.getTitleInput().getAttribute("value"),
                expectedValues.get("title"));
        Assert.assertEquals(addTestCasePage.getTemplateDropDown().getText(),
                expectedValues.get("template"));
        Assert.assertEquals(addTestCasePage.getTypeDropDown().getText(),
                expectedValues.get("type"));
        Assert.assertEquals(addTestCasePage.getPriorityDropDown().getText(),
                expectedValues.get("priority"));
        Assert.assertEquals(addTestCasePage.getAutomationTypeDropDown().getText(),
                expectedValues.get("automation type"));
        Assert.assertEquals(addTestCasePage.getPreconditionsInput().getText(),
                expectedValues.get("preconditions"));
        Assert.assertEquals(addTestCasePage.getStepsInput().getText(),
                expectedValues.get("steps"));
    }
}
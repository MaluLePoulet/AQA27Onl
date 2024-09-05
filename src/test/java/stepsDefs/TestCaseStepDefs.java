package stepsDefs;

import baseEntities.BaseTest;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.AddTestCasePage;
import pages.menus.SideMenuPage;

import java.util.List;
import java.util.Map;

public class TestCaseStepDefs extends BaseTest {
    BaseTest baseTest;

    SideMenuPage sideMenuPage;
    AddTestCasePage addTestCasePage;

    public TestCaseStepDefs(BaseTest baseTest) {
        this.baseTest = baseTest;
    }

    @When("user clicks add test case button")
    public void clickAddTCButton() {
        sideMenuPage = new SideMenuPage(baseTest.driver);
        sideMenuPage.clickAddTCButton();
    }

    @Then("add test case page is open")
    public void isAddTCPageOpen() {
        addTestCasePage = new AddTestCasePage(baseTest.driver);
        Assert.assertTrue(addTestCasePage.isPageOpen());
    }

    @When("user creates test case with")
    public void createTCWith(DataTable parameters) {
        List<Map<String,String>> expectedValues = parameters.asMaps(String.class, String.class);
        addTestCasePage.setTitleInput(expectedValues.get(0).get("title"));
        addTestCasePage.getTemplateDropDown().selectByText(expectedValues.get(0).get("template"));
        addTestCasePage.getTypeDropDown().selectByText(expectedValues.get(0).get("type"));
        addTestCasePage.getPriorityDropDown().selectByText(expectedValues.get(0).get("priority"));
        addTestCasePage.getAutomationTypeDropDown().selectByText(expectedValues.get(0).get("automation type"));
        addTestCasePage.setPreconditionsInput(expectedValues.get(0).get("preconditions"));
        addTestCasePage.setStepsInput(expectedValues.get(0).get("steps"));
        addTestCasePage.clickSaveTCButton();
    }

    @Then("created test case page is open")
    public void isTestCasePageOpen() {
    }
}

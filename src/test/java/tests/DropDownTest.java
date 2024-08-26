package tests;

import baseEntities.BaseTest;
import org.testng.annotations.Test;
import pages.AddTestCasePage;

public class DropDownTest extends BaseTest {

    @Test
    public void dropDownTest() {
        AddTestCasePage addTestCasePage = new AddTestCasePage(driver);
        addTestCasePage.openPageByUrl();

        addTestCasePage.getTypeDropDown().selectByIndex(10);
        addTestCasePage.getTemplateDropDown().selectByText("Test Case (Steps)");
    }
}

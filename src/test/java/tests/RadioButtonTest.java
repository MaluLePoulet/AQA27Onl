package tests;

import baseEntities.BaseTest;
import org.testng.annotations.Test;
import pages.projects.AddProjectPage;

public class RadioButtonTest extends BaseTest {

    @Test
    public void radioButtonTest() {
        AddProjectPage addProjectPage = new AddProjectPage(driver);
        addProjectPage.openPageByUrl();

        addProjectPage.getProjectTypeRadioButton().selectByIndex(2);
        addProjectPage.getProjectTypeRadioButton().selectByValue("2");
        addProjectPage.getProjectTypeRadioButton().selectByText("Use a single repository for all cases (recommended)");
    }
}

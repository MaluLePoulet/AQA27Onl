package tests;

import baseEntities.BaseTest;
import org.testng.annotations.Test;
import pages.projects.EditProjectPage;

public class CheckboxTest extends BaseTest {

    @Test
    public void checkboxTest() {
        EditProjectPage editProjectPage = new EditProjectPage(driver);
        editProjectPage.openPageByUrl();

        editProjectPage.getShowAnnouncementCheckbox().set();
        editProjectPage.getCasesStatusesCheckbox().set();
        editProjectPage.getCompleteProjectCheckbox().set();
        editProjectPage.getShowAnnouncementCheckbox().remove();
    }
}

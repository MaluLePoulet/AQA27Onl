package pages.projects;

import elements.Button;
import elements.Checkbox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditProjectPage extends BaseProjectPage {
    private final static String pagePath = "/index.php?/admin/projects/edit/45/1";
    private final By EDIT_PROJECT_BUTTON_LOCATOR = By.id("accept");
    private final By SHOW_ANNOUNCEMENT_CHECKBOX_LOCATOR = By.id("show_announcement");
    private final By CASES_STATUSES_CHECKBOX_LOCATOR = By.id("case_statuses_enabled");
    private final By COMPLETE_PROJECT_CHECKBOX_LOCATOR = By.id("is_completed");

    public EditProjectPage(WebDriver driver) {
        super(driver);
    }

    public Button getEditProjectButton() {
        return new Button(pageDriver, EDIT_PROJECT_BUTTON_LOCATOR);
    }

    public Checkbox getShowAnnouncementCheckbox() {
        return new Checkbox(pageDriver, SHOW_ANNOUNCEMENT_CHECKBOX_LOCATOR);
    }

    public Checkbox getCasesStatusesCheckbox() {
        return new Checkbox(pageDriver, CASES_STATUSES_CHECKBOX_LOCATOR);
    }

    public Checkbox getCompleteProjectCheckbox() {
        return new Checkbox(pageDriver, COMPLETE_PROJECT_CHECKBOX_LOCATOR);
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }
}

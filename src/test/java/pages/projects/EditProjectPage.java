package pages.projects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class EditProjectPage extends BaseProjectPage {
    private final static String pagePath = "/index.php?/admin/projects/edit/1";
    private final By EDIT_PROJECT_BUTTON_LOCATOR = By.id("accept");
    private final By SHOW_ANNOUNCEMENT_CHECKBOX_LOCATOR = By.id("show_announcement");
    private final By CASES_STATUSES_CHECKBOX_LOCATOR = By.id("case_statuses_enabled");
    private final By COMPLETE_PROJECT_CHECKBOX_LOCATOR = By.id("is_completed");

    public SelenideElement getEditProjectButton() {
        return $(EDIT_PROJECT_BUTTON_LOCATOR);
    }

    public SelenideElement getShowAnnouncementCheckbox() {
        return $(SHOW_ANNOUNCEMENT_CHECKBOX_LOCATOR);
    }

    public SelenideElement getCasesStatusesCheckbox() {
        return $(CASES_STATUSES_CHECKBOX_LOCATOR);
    }

    public SelenideElement getCompleteProjectCheckbox() {
        return $(COMPLETE_PROJECT_CHECKBOX_LOCATOR);
    }

    public void openPageByUrl() {
        super.load();
    }
}

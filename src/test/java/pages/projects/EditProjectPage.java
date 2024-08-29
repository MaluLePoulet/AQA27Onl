package pages.projects;

import elements.Checkbox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditProjectPage extends BaseProjectPage {
    private final static String pagePath = "/index.php?/admin/projects/edit/1";
    private final By COMPLETE_PROJECT_CHECKBOX_LOCATOR = By.id("is_completed");

    public EditProjectPage(WebDriver driver) {
        super(driver);
    }

    public Checkbox getCompleteProjectCheckbox() {
        return new Checkbox(pageDriver, COMPLETE_PROJECT_CHECKBOX_LOCATOR);
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }
}

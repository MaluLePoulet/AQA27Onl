package pages.projects;

import elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.administration.ProjectsPage;

public class AddProjectPage extends BaseProjectPage {
    private final static String pagePath = "/index.php?/admin/projects/add/1";
    private final By ADD_PROJECT_BUTTON_LOCATOR = By.id("accept");

    public AddProjectPage(WebDriver driver) {
        super(driver);
    }

    public Button getSaveProjectButton() {
        return new Button(pageDriver, ADD_PROJECT_BUTTON_LOCATOR);
    }

    public ProjectsPage clickSaveProjectButton() {
        getSaveProjectButton().click();
       return new ProjectsPage(pageDriver);
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }
}

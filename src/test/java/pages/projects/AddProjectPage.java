package pages.projects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddProjectPage extends BaseProjectPage {
    private final static String pagePath = "/index.php?/admin/projects/add/1";
    private final By HEADER_TITLE_LABEL_LOCATOR = By.xpath("//div[contains(@class, 'content-header-title') and contains(text(), 'Add Project')]");
    private final By ADD_PROJECT_BUTTON_LOCATOR = By.id("accept");

    public AddProjectPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpen() {
        return waitsService.presenceOfElementLocated(HEADER_TITLE_LABEL_LOCATOR)
                .getText()
                .trim()
                .equals("Add Project");
    }
}

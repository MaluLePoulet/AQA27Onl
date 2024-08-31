package pages.overview;

import elements.Button;
import elements.UIElement;
import elements.table.Table;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.menus.SideMenuPage;
import pages.projects.BaseProjectPage;

public class ProjectsPage extends BaseProjectPage {
    public SideMenuPage sideMenuPage;

    private final By ADD_PROJECT_BUTTON_LOCATOR = By.id("accept");
    private final By PROJECTS_LIST_ELEMENT_LOCATOR = By.cssSelector("table.grid");
    private final By SUCCESS_MESSAGE_FIELD_LOCATOR = By.cssSelector(".message.message-success");

    public ProjectsPage(WebDriver driver) {
        super(driver);

        sideMenuPage = new SideMenuPage(driver);
    }

    public Button getAddProjectButton() {
        return new Button(pageDriver, ADD_PROJECT_BUTTON_LOCATOR);
    }

    public UIElement getSuccessMessageElement() {
        return new UIElement(pageDriver, SUCCESS_MESSAGE_FIELD_LOCATOR);
    }

    public Table getProjectsList() {
        return new Table(pageDriver, PROJECTS_LIST_ELEMENT_LOCATOR);
    }
}
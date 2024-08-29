package pages.menus;

import baseEntities.BasePage;
import elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.projects.AddProjectPage;

public class SideMenuPage extends BasePage {
    private final By SIDEBAR_LOCATOR = By.id("sidebar");
    private final By ADD_TEST_CASE_BUTTON_LOCATOR = By.id("sidebar-cases-add");
    private final By ADD_PROJECT_BUTTON = By.id("sidebar-projects-add");

    public SideMenuPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return SIDEBAR_LOCATOR;
    }

    public Button getAddTestCaseButton() {
        return new Button(pageDriver, ADD_TEST_CASE_BUTTON_LOCATOR);
    }

    public Button getAddProjectButton() {
        return new Button(pageDriver,ADD_PROJECT_BUTTON);
    }

    public AddProjectPage clickAddProjectButton() {
        getAddProjectButton().click();
        return new AddProjectPage(pageDriver);
    }
}
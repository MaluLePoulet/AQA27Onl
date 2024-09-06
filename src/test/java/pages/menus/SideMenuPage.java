package pages.menus;

import baseEntities.BasePage;
import elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.AddMilestonePage;
import pages.AddTestCasePage;
import pages.projects.AddProjectPage;

public class SideMenuPage extends BasePage {
    private final By SIDEBAR_LOCATOR = By.id("sidebar");
    private final By ADD_TEST_CASE_BUTTON_LOCATOR = By.id("sidebar-cases-add");
    private final By ADD_PROJECT_BUTTON_LOCATOR = By.id("sidebar-projects-add");
    private final By ADD_MILESTONE_BUTTON_LOCATOR = By.id("sidebar-milestones-add");
    private final By DELETE_TEST_CASE_BUTTON_LOCATOR = By.xpath("//span[@data-testid='editCaseDeleteButton']");

    public SideMenuPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return SIDEBAR_LOCATOR;
    }

    public Button getAddTCButton() {
        return new Button(pageDriver, ADD_TEST_CASE_BUTTON_LOCATOR);
    }

    public Button getAddProjectButton() {
        return new Button(pageDriver, ADD_PROJECT_BUTTON_LOCATOR);
    }

    public Button getAddMilestoneButton() {
        return new Button(pageDriver, ADD_MILESTONE_BUTTON_LOCATOR);
    }

    public Button getDeleteTCButton() {
        return new Button(pageDriver, DELETE_TEST_CASE_BUTTON_LOCATOR);
    }

    public AddProjectPage clickAddProjectButton() {
        getAddProjectButton().click();
        return new AddProjectPage(pageDriver);
    }

    public AddMilestonePage clickAddMilestoneButton() {
        getAddMilestoneButton().click();
        return new AddMilestonePage(pageDriver);
    }

    public AddTestCasePage clickAddTCButton() {
        getAddTCButton().click();
        return new AddTestCasePage(pageDriver);
    }

    public void clickDeleteTCButton() {
        getDeleteTCButton().click();
    }
}
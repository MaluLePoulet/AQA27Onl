package pages.menus;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    public WebElement getAddTestCaseButton() {
        return waitsService.elementToBeClickable(ADD_TEST_CASE_BUTTON_LOCATOR);
    }

    public WebElement getAddProjectButton() {
        return waitsService.elementToBeClickable(ADD_PROJECT_BUTTON);
    }

    public AddProjectPage clickAddProjectButton() {
        getAddProjectButton().click();
        return new AddProjectPage(pageDriver);
    }

}
package pages.menus;

import baseEntities.BasePage;
import elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SideMenuPage extends BasePage {
    private final By SIDEBAR_LOCATOR = By.id("sidebar");
    private final By ADD_TEST_CASE_BUTTON_LOCATOR = By.id("sidebar-cases-add");

    public SideMenuPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected WebElement getPageIdentifier() {
        return pageDriver.findElement(SIDEBAR_LOCATOR);
    }

    public Button getAddTestCaseButton() {
        return new Button(pageDriver, ADD_TEST_CASE_BUTTON_LOCATOR);
    }
}
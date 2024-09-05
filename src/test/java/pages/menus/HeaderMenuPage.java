package pages.menus;

import baseEntities.BasePage;
import elements.UIElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderMenuPage extends BasePage {
    private static final By HEADER_MENU_LOCATOR = By.id("header");
    private final By NAVIGATION_MILESTONES_BUTTON_LOCATOR = By.id("navigation-milestones");


    public HeaderMenuPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return HEADER_MENU_LOCATOR;
    }

    public UIElement getNavigationMilestonesButton() {
        return new UIElement(pageDriver, NAVIGATION_MILESTONES_BUTTON_LOCATOR);
    }

    public void clickNavigationMilestonesButton() {
        getNavigationMilestonesButton().click();
    }
}
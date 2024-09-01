package pages.menus;

import baseEntities.BasePage;
import org.openqa.selenium.By;

public class TopMenuPage extends BasePage {
    private final By TOP_PANEL_LOCATOR = By.className("top-panel");

    @Override
    protected By getPageIdentifier() {
        return TOP_PANEL_LOCATOR;
    }

    @Override
    protected String getPagePath() {
        return "";
    }

    public void logout() {

    }
}

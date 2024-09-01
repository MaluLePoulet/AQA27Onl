package pages.menus;

import baseEntities.BasePage;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SideMenuPage extends BasePage {
    private final By SIDEBAR_LOCATOR = By.id("sidebar");
    private final By ADD_TEST_CASE_BUTTON_LOCATOR = By.id("sidebar-cases-add");

    @Override
    protected By getPageIdentifier() {
        return SIDEBAR_LOCATOR;
    }

    @Override
    protected String getPagePath() {
        return "";
    }

    public SelenideElement getAddTestCaseButton() {
        return $(ADD_TEST_CASE_BUTTON_LOCATOR);
    }
}
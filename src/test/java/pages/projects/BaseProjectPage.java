package pages.projects;

import baseEntities.BasePage;
import elements.Input;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BaseProjectPage extends BasePage {
    private final By NAME_INPUT_LOCATOR = By.id("name");

    public BaseProjectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return NAME_INPUT_LOCATOR;
    }

    @Override
    protected String getPagePath() {
        return "";
    }

    public Input getNameInput() {
        return new Input(pageDriver, NAME_INPUT_LOCATOR);
    }
}

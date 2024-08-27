package pages.projects;

import baseEntities.BasePage;
import elements.Input;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseProjectPage extends BasePage {
    private final By NAME_INPUT_LOCATOR = By.id("name");

    public BaseProjectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected WebElement getPageIdentifier() {
        return pageDriver.findElement(NAME_INPUT_LOCATOR);
    }

    public Input getNameInput() {
        return new Input(pageDriver, NAME_INPUT_LOCATOR);
    }
}

package pages.projects;

import baseEntities.BasePage;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class BaseProjectPage extends BasePage {
    private final By NAME_INPUT_LOCATOR = By.id("name");

    @Override
    protected By getPageIdentifier() {
        return NAME_INPUT_LOCATOR;
    }

    @Override
    protected String getPagePath() {
        return "";
    }

    public SelenideElement getNameInput() {
        return $(NAME_INPUT_LOCATOR);
    }
}

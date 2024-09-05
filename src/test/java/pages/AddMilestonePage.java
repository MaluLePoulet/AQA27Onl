package pages;

import baseEntities.BasePage;
import elements.Button;
import elements.Checkbox;
import elements.Input;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.overview.MilestonesPage;

public class AddMilestonePage extends BasePage {
    private final By NAME_INPUT_LOCATOR = By.id("name");
    private final By REFERENCES_INPUT_LOCATOR = By.id("reference");
    private final By DESCRIPTION_INPUT_LOCATOR = By.id("description_display");
    private final By MILESTONE_COMPETED_CHECKBOX_LOCATOR = By.id("is_completed");
    private final By ADD_MILESTONE_BUTTON_LOCATOR = By.id("accept");

    public AddMilestonePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return NAME_INPUT_LOCATOR;
    }

    public Input getNameInput() {
        return new Input(pageDriver, NAME_INPUT_LOCATOR);
    }

    public Input getReferencesInput() {
        return new Input(pageDriver, REFERENCES_INPUT_LOCATOR);
    }

    public Input getDescriptionInput() {
        return new Input(pageDriver, DESCRIPTION_INPUT_LOCATOR);
    }

    public Checkbox getMilestoneCompletedCheckbox() {
        return new Checkbox(pageDriver, MILESTONE_COMPETED_CHECKBOX_LOCATOR);
    }

    public Button getAddMilestoneButton() {
        return new Button(pageDriver, ADD_MILESTONE_BUTTON_LOCATOR);
    }

    public AddMilestonePage setNameInput(String text) {
        getNameInput().clearAndWrite(text);
        return this;
    }

    public AddMilestonePage setReferencesInput(String text) {
        getReferencesInput().clearAndWrite(text);
        return this;
    }

    public AddMilestonePage setDescriptionInput(String text) {
        getDescriptionInput().clearAndWrite(text);
        return this;
    }

    public MilestonesPage clickAddMilestoneButton() {
        getAddMilestoneButton().click();
        return new MilestonesPage(pageDriver);
    }
}
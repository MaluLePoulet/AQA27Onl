package pages.projects;

import baseEntities.BasePage;
import elements.Checkbox;
import elements.Input;
import elements.RadioButton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BaseProjectPage extends BasePage {
    private final By NAME_INPUT_LOCATOR = By.id("name");
    private final By ANNOUNCEMENT_INPUT_LOCATOR = By.id("announcement_display");
    private final By SHOW_ANNOUNCEMENT_CHECKBOX_LOCATOR = By.id("show_announcement");
    private final By PROJECT_TYPE_RADIO_BUTTON_LOCATOR = By.cssSelector("[name='suite_mode']");
    private final By TC_APPROVALS_CHECKBOX_LOCATOR = By.id("case_statuses_enabled");

    public BaseProjectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return NAME_INPUT_LOCATOR;
    }

    public Input getNameInput() {
        return new Input(pageDriver, NAME_INPUT_LOCATOR);
    }

    public Input getAnnouncementInput() {
        return new Input(pageDriver, ANNOUNCEMENT_INPUT_LOCATOR);
    }

    public Checkbox getShowAnnouncementCheckbox() {
        return new Checkbox(pageDriver, SHOW_ANNOUNCEMENT_CHECKBOX_LOCATOR);
    }

    public RadioButton getProjectTypeRadioButton() {
        return new RadioButton(pageDriver, PROJECT_TYPE_RADIO_BUTTON_LOCATOR);
    }

    public Checkbox getTCApprovalsCheckbox() {
        return new Checkbox(pageDriver, TC_APPROVALS_CHECKBOX_LOCATOR);
    }

    public BaseProjectPage setNameInput(String text) {
        getNameInput().write(text);
        return this;
    }

    public BaseProjectPage setAnnouncementInput(String text) {
        getAnnouncementInput().write(text);
        return this;
    }

    public BaseProjectPage setShowAnnouncementCheckbox(boolean flag) {
        getShowAnnouncementCheckbox().setFlag(flag);
        return this;
    }

    public BaseProjectPage selectProjectTypeByText(String text) {
        getProjectTypeRadioButton().selectByText(text);
        return this;
    }

    public BaseProjectPage selectProjectTypeByIndex(int index) {
        getProjectTypeRadioButton().selectByIndex(index);
        return this;
    }

    public BaseProjectPage setTCApprovalsCheckbox(boolean flag) {
        getTCApprovalsCheckbox().setFlag(flag);
        return this;
    }

    public AddProjectPage addProjectPage() {
        return new AddProjectPage(pageDriver);
    }
}

package pages;

import baseEntities.BasePage;
import elements.Button;
import elements.DropDown;
import elements.Input;
import elements.UIElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddTestCasePage extends BasePage {
    private final static String pagePath = "/index.php?/cases/add/1";
    private final By HEADER_TITLE_LABEL_LOCATOR = By.xpath("//div[contains(@class, 'content-header-title') and contains(text(), 'Add Test Case')]");
    private final By TITLE_INPUT_LOCATOR = By.id("title");
    private final By SECTION_DROP_DOWN_LOCATOR = By.id("section_id_chzn");
    private final By TEMPLATE_DROP_DOWN_LOCATOR = By.id("template_id_chzn");
    private final By TYPE_DROP_DOWN_LOCATOR = By.id("type_id_chzn");
    private final By PRIORITY_DROP_DOWN_LOCATOR = By.id("priority_id_chzn");
    private final By AUTOMATION_TYPE_DROP_DOWN_LOCATOR = By.id("custom_automation_type_chzn");
    private final By PRECONDITIONS_INPUT_LOCATOR = By.id("custom_preconds_display");
    private final By STEPS_INPUT_LOCATOR = By.id("custom_steps_display");
    private final By SAVE_TEST_CASE_BUTTON_LOCATOR = By.id("accept");

    public AddTestCasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return HEADER_TITLE_LABEL_LOCATOR;
    }

    public UIElement getHeaderTitle() {
        return new UIElement(pageDriver, HEADER_TITLE_LABEL_LOCATOR);
    }

    public Input getTitleInput() {
        return new Input(pageDriver, TITLE_INPUT_LOCATOR);
    }

    public DropDown getSectionDropDown() {
        return new DropDown(pageDriver, SECTION_DROP_DOWN_LOCATOR);
    }

    public DropDown getTemplateDropDown() {
        return new DropDown(pageDriver, TEMPLATE_DROP_DOWN_LOCATOR);
    }

    public DropDown getTypeDropDown() {
        return new DropDown(pageDriver, TYPE_DROP_DOWN_LOCATOR);
    }

    public DropDown getPriorityDropDown() {
        return new DropDown(pageDriver, PRIORITY_DROP_DOWN_LOCATOR);
    }

    public DropDown getAutomationTypeDropDown() {
        return new DropDown(pageDriver, AUTOMATION_TYPE_DROP_DOWN_LOCATOR);
    }

    public Input getPreconditionsInput() {
        return new Input(pageDriver, PRECONDITIONS_INPUT_LOCATOR);
    }

    public Input getStepsInput() {
        return new Input(pageDriver, STEPS_INPUT_LOCATOR);
    }

    public Button getSaveTCButton() {
        return new Button(pageDriver, SAVE_TEST_CASE_BUTTON_LOCATOR);
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    public void setTitleInput(String text) {
        getTitleInput().clearAndWrite(text);
    }

    public void setPreconditionsInput(String text) {
        getPreconditionsInput().clearAndWrite(text);
    }

    public void setStepsInput(String text) {
        getStepsInput().clearAndWrite(text);
    }

    public void clickSaveTCButton() {
        getSaveTCButton().click();
    }
}
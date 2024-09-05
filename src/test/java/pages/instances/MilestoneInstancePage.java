package pages.instances;

import baseEntities.BasePage;
import elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MilestoneInstancePage extends BasePage {
    private static final By HEADER_TITLE_LABEL_LOCATOR = By.xpath("//div[contains(@class, 'content-header-title')]");
    private final By EDIT_MILESTONE_BUTTON_LOCATOR = By.cssSelector(".button-edit");

    public MilestoneInstancePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return HEADER_TITLE_LABEL_LOCATOR;
    }

    public Button getEditMilestoneButton() {
        return new Button(pageDriver, EDIT_MILESTONE_BUTTON_LOCATOR);
    }

    public void clickEditMilestoneButton() {
        getEditMilestoneButton().click();
    }

}

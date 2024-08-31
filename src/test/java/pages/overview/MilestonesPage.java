package pages.overview;

import baseEntities.BasePage;
import elements.UIElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MilestonesPage extends BasePage {
    private final By HEADER_TITLE_LABEL_LOCATOR = By.xpath("//div[contains(@class, 'content-header-title') and contains(text(), 'Milestones')]");
    private final By SUCCESS_MESSAGE_FIELD_LOCATOR = By.cssSelector(".message.message-success");

    public MilestonesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return HEADER_TITLE_LABEL_LOCATOR;
    }

    public UIElement getSuccessMessageElement() {
        return new UIElement(pageDriver, SUCCESS_MESSAGE_FIELD_LOCATOR);
    }

    public boolean isMilestoneCreated() {
        return getSuccessMessageElement().isDisplayed();
    }
}

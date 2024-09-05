package pages.overview;

import baseEntities.BasePage;
import elements.UIElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.menus.HeaderMenuPage;

import java.util.List;

public class MilestonesPage extends BasePage {
    public HeaderMenuPage headerMenuPage;
    private final By HEADER_TITLE_LABEL_LOCATOR = By.xpath("//div[contains(@class, 'content-header-title') and contains(text(), 'Milestones')]");
    private final By SUCCESS_MESSAGE_FIELD_LOCATOR = By.cssSelector(".message.message-success");
    private final By ACTIVE_MILESTONES_BLOCK_LOCATOR = By.id("active_block");
    private final By CONFIRM_DELETE_BUTTON_LOCATOR = By.xpath("//a[@data-testid='caseFieldsTabDeleteDialogButtonOk']");

    public MilestonesPage(WebDriver driver) {
        super(driver);

        headerMenuPage = new HeaderMenuPage(pageDriver);
    }

    @Override
    protected By getPageIdentifier() {
        return HEADER_TITLE_LABEL_LOCATOR;
    }

    public UIElement getSuccessMessageElement() {
        return new UIElement(pageDriver, SUCCESS_MESSAGE_FIELD_LOCATOR);
    }

    public List<UIElement> getActiveMilestonesList() {
        return new UIElement(pageDriver, ACTIVE_MILESTONES_BLOCK_LOCATOR)
                .findUIElements(By.xpath("//div[@class='summary-title text-ppp']//a"));
    }

    public List<UIElement> getDeleteIconsList() {
        return new UIElement(pageDriver, ACTIVE_MILESTONES_BLOCK_LOCATOR)
                .findUIElements(By.className("icon-small-delete"));
    }

    public UIElement getConfirmDeleteButton() {
        return new UIElement(pageDriver, CONFIRM_DELETE_BUTTON_LOCATOR);
    }

    public void clickConfirmDeleteButton() {
        getConfirmDeleteButton().click();
    }

    public boolean isMilestoneCreated() {
        return getSuccessMessageElement().isDisplayed();
    }
}
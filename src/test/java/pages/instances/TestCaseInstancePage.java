package pages.instances;

import baseEntities.BasePage;
import elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCaseInstancePage extends BasePage {
    String testCaseName = waitsService.presenceOfElementLocated(By.xpath("//div[contains(@class, 'content-header-title')]")).getText();
    private static final String HEADER_TITLE_LABEL_LOCATOR = "//div[contains(@class, 'content-header-title') and contains(text(), 'replace')]";
    private final By EDIT_TEST_CASE_BUTTON_LOCATOR = By.cssSelector(".button-edit");
    private final By DELETE_PERMANENTLY_TEST_CASE_BUTTON_LOCATOR = By.xpath("//a[contains(@data-testid, 'deleteCaseDialogActionSecondary')and contains(text(), 'Delete Permanently')]");
    private final By DELETE_PERMANENTLY_TEST_CASE_SECOND_BUTTON_LOCATOR = By.xpath("//a[contains(@data-testid, 'deleteCaseDialogActionDefault')and contains(text(), 'Delete Permanently')]");

    public TestCaseInstancePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return By.xpath(HEADER_TITLE_LABEL_LOCATOR.replace("replace", testCaseName));
    }

    public Button getEditButton() {
        return new Button(pageDriver, EDIT_TEST_CASE_BUTTON_LOCATOR);
    }

    public Button getDeletePermanentlyTCButton() {
        return new Button(pageDriver, DELETE_PERMANENTLY_TEST_CASE_BUTTON_LOCATOR);
    }

    public Button getDeletePermanentlyTCSecondButton() {
        return new Button(pageDriver, DELETE_PERMANENTLY_TEST_CASE_SECOND_BUTTON_LOCATOR);
    }

    public void clickEditButton() {
        getEditButton().click();
    }

    public void clickDeletePermanentlyTCButton() {
        getDeletePermanentlyTCButton().click();
    }

    public void clickDeletePermanentlyTCSecondButton() {
        getDeletePermanentlyTCSecondButton().click();
    }
}
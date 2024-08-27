package pages;

import baseEntities.BasePage;
import elements.DropDown;
import elements.UIElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddTestCasePage extends BasePage {
    private final static String pagePath = "/index.php?/cases/add/1";
    private final By HEADER_TITLE_LABEL_LOCATOR = By.xpath("//div[contains(@class, 'content-header-title') and contains(text(), 'Add Test Case')]");
    private final By TEMPLATE_DROP_DOWN_LOCATOR = By.id("template_id_chzn");
    private final By TYPE_DROP_DOWN_LOCATOR = By.id("type_id_chzn");

    public AddTestCasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return HEADER_TITLE_LABEL_LOCATOR;
    }

    @Override
    protected String getPagePath() {
        return pagePath;
    }

    public UIElement getHeaderTitle() {
        return new UIElement(pageDriver, HEADER_TITLE_LABEL_LOCATOR);
    }

    public DropDown getTemplateDropDown() {
        return new DropDown(pageDriver, TEMPLATE_DROP_DOWN_LOCATOR);
    }

    public DropDown getTypeDropDown() {
        return new DropDown(pageDriver, TYPE_DROP_DOWN_LOCATOR);
    }

    public void openPageByUrl() {
        super.load();
    }
}
package pages;

import baseEntities.BasePage;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AddTestCasePage extends BasePage {
    private final static String pagePath = "/index.php?/cases/add/1";
    private final By HEADER_TITLE_LABEL_LOCATOR = By.xpath("//div[contains(@class, 'content-header-title') and contains(text(), 'Add Test Case')]");
    private final By TEMPLATE_DROP_DOWN_LOCATOR = By.id("template_id_chzn");
    private final By TYPE_DROP_DOWN_LOCATOR = By.id("type_id_chzn");

    @Override
    protected By getPageIdentifier() {
        return HEADER_TITLE_LABEL_LOCATOR;
    }

    @Override
    protected String getPagePath() {
        return pagePath;
    }

    public SelenideElement getHeaderTitle() {
        return $(HEADER_TITLE_LABEL_LOCATOR);
    }

    public SelenideElement getTemplateDropDown() {
        return $(TEMPLATE_DROP_DOWN_LOCATOR);
    }

    public SelenideElement getTypeDropDown() {
        return $(TYPE_DROP_DOWN_LOCATOR);
    }

    public void openPageByUrl() {
        super.load();
    }
}
package pages;

import baseEntities.BasePage;
import elements.UIElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.menus.SideMenuPage;
import pages.menus.TopMenuPage;

public class DashboardPage extends BasePage {
    private static final String pagePath = "/index.php?/dashboard";
    public TopMenuPage topMenuPage;
    public SideMenuPage sideMenuPage;
    private static final By HEADER_TITLE_LABEL_LOCATOR = By.xpath("//div[contains(@class, 'content-header-title') and contains(text(), 'All Projects')]");
    private final By PROJECTS_LIST_ELEMENT_LOCATOR = By.xpath("//div[@class = 'table summary summary-auto']");

    public DashboardPage(WebDriver driver) {
        super(driver);

        topMenuPage = new TopMenuPage(driver);
        sideMenuPage = new SideMenuPage(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return HEADER_TITLE_LABEL_LOCATOR;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    public UIElement getProjectsList() {
        return new UIElement(pageDriver, PROJECTS_LIST_ELEMENT_LOCATOR);
    }
}
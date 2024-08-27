package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.menus.SideMenuPage;
import pages.menus.TopMenuPage;

public class DashboardPage extends BasePage {
    private final static String pagePath = "/index.php?/dashboard";
    public TopMenuPage topMenuPage;
    public SideMenuPage sideMenuPage;
    private static final By HEADER_TITLE_LABEL_LOCATOR = By.xpath("//div[contains(@class, 'content-header-title') and contains(text(), 'All Projects')]");

    public DashboardPage(WebDriver driver) {
        super(driver);

       // topMenuPage = new TopMenuPage(driver);
       // sideMenuPage = new SideMenuPage(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return HEADER_TITLE_LABEL_LOCATOR;
    }

    @Override
    protected String getPagePath() {
        return pagePath;
    }

    public void openPageByUrl() {
        super.load();
    }
}

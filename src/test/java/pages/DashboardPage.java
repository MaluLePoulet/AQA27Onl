package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.menus.SideMenuPage;
import pages.menus.TopMenuPage;

public class DashboardPage extends BasePage {
    private final static String pagePath = "/index.php?/dashboard";
    public TopMenuPage topMenuPage;
    public SideMenuPage sideMenuPage;
    private final By HEADER_TITLE_LABEL_LOCATOR = By.xpath("//div[contains(@class, 'content-header-title') and contains(text(), 'All Projects')]");

    public DashboardPage(WebDriver driver) {
        super(driver);

        topMenuPage = new TopMenuPage(driver);
        sideMenuPage = new SideMenuPage(driver);
    }

    @Override
    protected WebElement getPageIdentifier() {
        return pageDriver.findElement(HEADER_TITLE_LABEL_LOCATOR);
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }
}

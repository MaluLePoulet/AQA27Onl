package baseEntities;

import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.LoginPageWithPageFactory;

public class BaseStep {
    protected WebDriver driver;
    protected LoginPageWithPageFactory loginPageWithPageFactory;
    protected DashboardPage dashboardPage;


    public BaseStep(WebDriver driver) {
        this.driver = driver;
        loginPageWithPageFactory = new LoginPageWithPageFactory(driver);
        dashboardPage = new DashboardPage(driver);
    }
}

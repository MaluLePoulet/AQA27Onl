package baseEntities;

import org.openqa.selenium.WebDriver;
import pages.AddMilestonePage;
import pages.DashboardPage;
import pages.LoginPage;
import pages.overview.MilestonesPage;
import pages.overview.ProjectsPage;

public class BaseStep {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    protected ProjectsPage projectsPage;
    protected AddMilestonePage addMilestonePage;
    protected MilestonesPage milestonesPage;

    public BaseStep(WebDriver driver) {
        this.driver = driver;

        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        projectsPage = new ProjectsPage(driver);
        addMilestonePage = new AddMilestonePage(driver);
        milestonesPage = new MilestonesPage(driver);
    }
}
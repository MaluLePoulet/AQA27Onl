package baseEntities;

import configuration.ReadProperties;
import models.User;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import services.BrowsersService;
import services.WaitsService;
import steps.ProjectSteps;
import steps.UserSteps;
import utils.InvokedListener;

@Listeners(InvokedListener.class)
public class BaseTest {
    protected WebDriver driver;
    protected UserSteps userSteps;
    protected ProjectSteps projectSteps;
    protected WaitsService waitsService;

    //Test Data
    protected User admin;

    @BeforeMethod
    public void setUp(ITestContext iTestContext) {
        driver = new BrowsersService().getDriver();
        waitsService = new WaitsService(driver);
        iTestContext.setAttribute("WebDriver", driver);

        userSteps = new UserSteps(driver);
        projectSteps = new ProjectSteps(driver);

        driver.get(ReadProperties.getUrl());

        admin = new User();
        admin.setUsername(ReadProperties.username());
        admin.setPassword(ReadProperties.password());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}

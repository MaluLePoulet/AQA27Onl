package baseEntities;

import com.github.javafaker.Faker;
import configuration.ReadProperties;
import models.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.LoginPage;
import services.BrowsersService;
import services.WaitsService;
import steps.MilestoneSteps;
import steps.ProjectSteps;
import steps.UserSteps;
import utils.InvokedListener;

@Listeners(InvokedListener.class)
public class BaseTest {
    protected WebDriver driver;
    protected UserSteps userSteps;
    protected ProjectSteps projectSteps;
    protected MilestoneSteps milestoneSteps;
    protected WaitsService waitsService;
    protected Faker faker;

    //Test Data
    public User admin;

    @BeforeMethod
    public void setUp(ITestContext iTestContext) {
        driver = new BrowsersService().getDriver();
        waitsService = new WaitsService(driver);
        faker = new Faker();
        iTestContext.setAttribute("WebDriver", driver);

        userSteps = new UserSteps(driver);
        projectSteps = new ProjectSteps(driver);
        milestoneSteps = new MilestoneSteps(driver);

        driver.get(ReadProperties.getUrl());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
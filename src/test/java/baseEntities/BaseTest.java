package baseEntities;

import com.github.javafaker.Faker;
import configuration.ReadProperties;
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
    protected Faker faker;

    @BeforeMethod
    public void setUp(ITestContext iTestContext) {
        driver = new BrowsersService().getDriver();
        waitsService = new WaitsService(driver);
        faker = new Faker();
        iTestContext.setAttribute("WebDriver", driver);


        userSteps = new UserSteps(driver);
        projectSteps = new ProjectSteps(driver);

        driver.get(ReadProperties.getUrl());
        userSteps.successfulLogin(ReadProperties.username(),ReadProperties.password());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}

package baseEntities;

import configuration.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import services.BrowsersService;
import services.WaitsService;
import steps.UserSteps;
import utils.InvokedListener;

@Listeners(InvokedListener.class)
public class BaseGuiTest {
    protected WebDriver driver;
    protected UserSteps userSteps;
    protected WaitsService waitsService;

    @BeforeMethod
    public void setUp(ITestContext iTestContext) {
        driver = new BrowsersService().getDriver();
        waitsService = new WaitsService(driver);
        iTestContext.setAttribute("WebDriver", driver);

        userSteps = new UserSteps(driver);

        driver.get(ReadProperties.getUrl());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
package baseEntities;

import configuration.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import services.BrowsersService;
import services.WaitsService;
import steps.UserSteps;

public class BaseTest {
    protected WebDriver driver;
    protected UserSteps userSteps;
    protected WaitsService waitsService;

    @BeforeMethod
    public void setUp() {
        driver = new BrowsersService().getDriver();
        waitsService = new WaitsService(driver);

        userSteps = new UserSteps(driver);

        driver.get(ReadProperties.getUrl());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}

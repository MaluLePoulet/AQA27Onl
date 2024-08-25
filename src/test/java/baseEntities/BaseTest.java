package baseEntities;

import configuration.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import services.BrowsersService;
import services.WaitsService;
import steps.CheckoutStep;
import steps.ItemStep;
import steps.UserStep;
import utils.InvokedListener;

@Listeners(InvokedListener.class)
public class BaseTest {
    protected WebDriver driver;
    protected UserStep userStep;
    protected ItemStep itemStep;
    protected CheckoutStep checkoutStep;
    protected WaitsService waitsService;

    @BeforeMethod
    public void setUp(ITestContext iTestContext) {
        driver = new BrowsersService().getDriver();
        waitsService = new WaitsService(driver);
        iTestContext.setAttribute("WebDriver", driver);

        userStep = new UserStep(driver);
        itemStep = new ItemStep(driver);
        checkoutStep = new CheckoutStep(driver);

        driver.get(ReadProperties.getUrl());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}

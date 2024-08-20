package baseEntities;

import configuration.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import services.BrowsersService;
import steps.CheckoutStep;
import steps.ItemStep;
import steps.UserStep;

public class BaseTest {
    protected WebDriver driver;
    protected UserStep userStep;
    protected ItemStep itemStep;
    protected CheckoutStep checkoutStep;

    @BeforeMethod
    public void setUp() {
        driver = new BrowsersService().getDriver();

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

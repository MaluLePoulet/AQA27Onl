package baseEntities;

import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.testng.SoftAsserts;
import configuration.ReadProperties;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import steps.CheckoutStep;
import steps.ItemStep;
import steps.UserStep;

import static com.codeborne.selenide.Selenide.open;

@Listeners(SoftAsserts.class)
public class BaseTest {
    protected UserStep userStep;
    protected ItemStep itemStep;
    protected CheckoutStep checkoutStep;

    @BeforeSuite
    public void beforeSuite() {
        Configuration.baseUrl = ReadProperties.getUrl();
        Configuration.assertionMode = AssertionMode.SOFT;
    }

    @BeforeMethod
    public void setUp() {
        open(ReadProperties.getUrl());

        userStep = new UserStep();
        itemStep = new ItemStep();
        checkoutStep = new CheckoutStep();
    }
}
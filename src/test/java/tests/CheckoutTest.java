package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;

public class CheckoutTest extends BaseTest {

    @Test(description = "Successful checkout test")
    @Description("This is to test if the checkout is done correctly")
    @Severity(SeverityLevel.CRITICAL)
    public void successfulCheckoutTest() {
        userStep.successfulLogin(ReadProperties.usernameStandard(), ReadProperties.password());
        itemStep.addItemToCart();
        CartPage cartPage = new CartPage(driver);
        cartPage.topMenuPage.clickShoppingCartElement();
        cartPage.clickCheckoutButton();

        Assert.assertEquals
                (checkoutStep.successfulCheckout().getCheckoutCompleteMessageElement().getText(),
                        "Thank you for your order!");
    }
}

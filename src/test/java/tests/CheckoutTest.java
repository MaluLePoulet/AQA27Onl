package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.TopMenuPage;

public class CheckoutTest extends BaseTest {

    @Test
    public void successfulCheckoutTest() {
        userStep.successfulLogin(ReadProperties.usernameStandard(), ReadProperties.password());
        itemStep.addItemToCart();
        TopMenuPage topMenuPage = new TopMenuPage(driver);
        topMenuPage.clickShoppingCartElement();
        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckoutButton();
        Assert.assertEquals
                (checkoutStep.successfulCheckout().getCheckoutCompleteMessageElement().getText(),
                        "Thank you for your order!");
    }
}

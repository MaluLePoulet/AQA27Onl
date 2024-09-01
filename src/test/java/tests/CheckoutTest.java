package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.annotations.Test;
import pages.CartPage;

import static com.codeborne.selenide.Condition.*;

public class CheckoutTest extends BaseTest {

    @Test
    public void successfulCheckoutTest() {
        userStep.successfulLogin(ReadProperties.usernameStandard(), ReadProperties.password());
        itemStep.addItemToCart();

        CartPage cartPage = new CartPage();
        cartPage.topMenuPage.clickShoppingCartElement();
        cartPage.clickCheckoutButton();

        checkoutStep.successfulCheckout().getCheckoutCompleteMessageElement()
                .should(exist)
                .shouldBe(visible)
                .shouldHave(text("Thank you for your order!"));
    }
}
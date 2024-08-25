package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TopMenuPage;

public class ItemTest extends BaseTest {

    @Test(description = "Successful add item to cart test")
    @Description("This is to test if the functionality of adding item to cart works correctly")
    @Severity(SeverityLevel.CRITICAL)
    public void addItemToCartTest() {
        userStep.successfulLogin(ReadProperties.usernameStandard(), ReadProperties.password());
        Assert.assertTrue(itemStep.addItemToCart().getRemoveFromCartButton().isDisplayed());
    }

    @Test(description = "Successful remove item from cart test")
    @Description("This is to test if the functionality of removing item from cart works correctly")
    @Severity(SeverityLevel.CRITICAL)
    public void removeItemFromCartTest() {
        userStep.successfulLogin(ReadProperties.usernameStandard(), ReadProperties.password());
        itemStep.addItemToCart();
        TopMenuPage topMenuPage = new TopMenuPage(driver);
        topMenuPage.clickShoppingCartElement();
        Assert.assertFalse(itemStep.removeItemFromCart().getRemovedItemElement().isDisplayed());
    }

    @Test(description = "Remove item from cart after login with error user")
    @Description("This is to test if the functionality of removing item from cart on page works correctly")
    @Severity(SeverityLevel.MINOR)
    public void removeItemFromCartOnPage() {
        userStep.successfulLogin(ReadProperties.usernameError(), ReadProperties.password());
        itemStep.addItemToCart();
        Assert.assertTrue(itemStep.removeItemFromCartOnPage().getAddToCartButton().isDisplayed());
    }
}

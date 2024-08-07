package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ItemTest extends BaseTest {

    @BeforeMethod
    public void login() {
        userStep.successfulLogin(ReadProperties.usernameStandard(), ReadProperties.password());
    }

    @Test
    public void addItemToCartTest() {
        Assert.assertTrue(itemStep.addItemToCart().getInventoryItemElement().isDisplayed());
    }

    @Test
    public void removeItemFromCartTest() {
        itemStep.addItemToCart();
        Assert.assertFalse(itemStep.removeItemFromCart().getRemovedItemElement().isDisplayed());
    }
}

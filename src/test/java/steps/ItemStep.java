package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.InventoryPage;


public class ItemStep extends BaseStep {

    public ItemStep(WebDriver driver) {
        super(driver);
    }

    public InventoryPage addItemToCart() {
        inventoryPage.clickAddToCartButton();
        topMenuPage.clickShoppingCartElement();
        return inventoryPage;
    }

    public CartPage removeItemFromCart() {
        topMenuPage.clickShoppingCartElement();
        inventoryPage.clickRemoveFromCartButton();
        return cartPage;
    }
}


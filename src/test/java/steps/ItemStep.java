package steps;

import baseEntities.BaseStep;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.InventoryPage;

public class ItemStep extends BaseStep {

    public ItemStep(WebDriver driver) {
        super(driver);
    }

    @Step(value = "Add item to cart")
    public InventoryPage addItemToCart() {
        inventoryPage.clickAddToCartButton();
        return inventoryPage;
    }

    @Step(value = "Remove item from cart on Inventory Page")
    public InventoryPage removeItemFromCartOnPage() {
        inventoryPage.clickRemoveFromCartButton();
        return inventoryPage;
    }

    @Step(value = "Remove item from cart on Cart Page")
    public CartPage removeItemFromCart() {
        topMenuPage.clickShoppingCartElement();
        inventoryPage.clickRemoveFromCartButton();
        return cartPage;
    }
}


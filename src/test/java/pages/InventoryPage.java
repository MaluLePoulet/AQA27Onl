package pages;

import baseEntities.BasePage;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class InventoryPage extends BasePage {
    private static final String pagePath = "inventory.html";
    private final SelenideElement PRODUCT_SORT_CONTAINER_LOCATOR = $(".product_sort_container");
    private final SelenideElement INVENTORY_ITEM_SLB_LOCATOR = $("#item_4_title_link");
    private final SelenideElement ADD_TO_CART_SLB_BUTTON_LOCATOR = $("#add-to-cart-sauce-labs-backpack");
    private final SelenideElement REMOVE_FROM_CART_SLB_BUTTON_LOCATOR = $("#remove-sauce-labs-backpack");

    public TopMenuPage topMenuPage;

    public InventoryPage() {
        topMenuPage = new TopMenuPage();
    }

    @Override
    protected SelenideElement getPageIdentifier() {
        return PRODUCT_SORT_CONTAINER_LOCATOR;
    }

    public SelenideElement getInventoryItemElement() {
        return INVENTORY_ITEM_SLB_LOCATOR;
    }

    public SelenideElement getAddToCartButton() {
        return ADD_TO_CART_SLB_BUTTON_LOCATOR;
    }

    public SelenideElement getRemoveFromCartButton() {
        return REMOVE_FROM_CART_SLB_BUTTON_LOCATOR;
    }

    public void clickAddToCartButton() {
        getAddToCartButton().click();
    }

    public void clickRemoveFromCartButton() {
        getRemoveFromCartButton().click();
    }

    @Override
    public void openPageByUrl(String pagePath) {
        super.openPageByUrl(pagePath);
    }
}
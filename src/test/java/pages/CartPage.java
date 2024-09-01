package pages;

import baseEntities.BasePage;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CartPage extends BasePage {
    private final SelenideElement CHECKOUT_BUTTON_LOCATOR = $("#checkout");
    private final SelenideElement REMOVED_ITEM_LOCATOR = $(".removed_cart_item");
    public TopMenuPage topMenuPage;

    public CartPage() {
        topMenuPage = new TopMenuPage();
    }

    @Override
    protected SelenideElement getPageIdentifier() {
        return CHECKOUT_BUTTON_LOCATOR;
    }

    public SelenideElement getCheckoutButton() {
        return CHECKOUT_BUTTON_LOCATOR;
    }

    public SelenideElement getRemovedItemElement() {
        return REMOVED_ITEM_LOCATOR;
    }

    public void clickCheckoutButton() {
        getCheckoutButton().click();
    }
}
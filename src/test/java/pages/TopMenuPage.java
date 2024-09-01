package pages;

import baseEntities.BasePage;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class TopMenuPage extends BasePage {
    private final SelenideElement SHOPPING_CART_CONTAINER_LOCATOR = $("#shopping_cart_container");

    public TopMenuPage() {
    }

    @Override
    protected SelenideElement getPageIdentifier() {
        return SHOPPING_CART_CONTAINER_LOCATOR;
    }

    public SelenideElement getShoppingCartElement() {
        return SHOPPING_CART_CONTAINER_LOCATOR;
    }

    public void clickShoppingCartElement() {
        getShoppingCartElement().click();
    }
}
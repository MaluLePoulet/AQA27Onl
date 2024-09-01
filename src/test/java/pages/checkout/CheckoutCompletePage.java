package pages.checkout;

import baseEntities.BasePage;
import com.codeborne.selenide.SelenideElement;
import pages.TopMenuPage;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutCompletePage extends BasePage {
    private final SelenideElement CHECKOUT_COMPLETE_MESSAGE_LOCATOR = $(".complete-header");
    public TopMenuPage topMenuPage;

    public CheckoutCompletePage() {
        topMenuPage = new TopMenuPage();
    }

    @Override
    protected SelenideElement getPageIdentifier() {
        return CHECKOUT_COMPLETE_MESSAGE_LOCATOR;
    }

    public SelenideElement getCheckoutCompleteMessageElement() {
        return CHECKOUT_COMPLETE_MESSAGE_LOCATOR;
    }
}
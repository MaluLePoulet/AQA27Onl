package pages.checkout;

import baseEntities.BasePage;
import com.codeborne.selenide.SelenideElement;
import pages.TopMenuPage;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutOverviewPage extends BasePage {
    private final SelenideElement FINISH_BUTTON_LOCATOR = $("#finish");
    public TopMenuPage topMenuPage;

    public CheckoutOverviewPage() {
        topMenuPage = new TopMenuPage();
    }

    @Override
    protected SelenideElement getPageIdentifier() {
        return FINISH_BUTTON_LOCATOR;
    }

    public SelenideElement getFinishButton() {
        return FINISH_BUTTON_LOCATOR;
    }

    public void clickFinishButton() {
        getFinishButton().click();
    }
}
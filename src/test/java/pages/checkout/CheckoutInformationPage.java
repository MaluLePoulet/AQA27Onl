package pages.checkout;

import baseEntities.BasePage;
import com.codeborne.selenide.SelenideElement;
import pages.TopMenuPage;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutInformationPage extends BasePage {
    private final SelenideElement FIRST_NAME_INPUT_LOCATOR = $("#first-name");
    private final SelenideElement LAST_NAME_INPUT_LOCATOR = $("#last-name");
    private final SelenideElement ZIP_CODE_INPUT_LOCATOR = $("#postal-code");
    private final SelenideElement CONTINUE_BUTTON_LOCATOR = $("#continue");
    public TopMenuPage topMenuPage;

    public CheckoutInformationPage() {
        topMenuPage = new TopMenuPage();
    }

    @Override
    protected SelenideElement getPageIdentifier() {
        return CONTINUE_BUTTON_LOCATOR;
    }

    public SelenideElement getFirstNameInput() {
        return FIRST_NAME_INPUT_LOCATOR;
    }

    public SelenideElement getLastNameInput() {
        return LAST_NAME_INPUT_LOCATOR;
    }

    public SelenideElement getZipCodeInput() {
        return ZIP_CODE_INPUT_LOCATOR;
    }

    public SelenideElement getContinueButton() {
        return CONTINUE_BUTTON_LOCATOR;
    }

    public void setFirstNameValue() {
        getFirstNameInput().val("Limon");
    }

    public void setLastNameValue() {
        getLastNameInput().val("Limonov");
    }

    public void setZipCodeValue() {
        getZipCodeInput().val("123456");
    }

    public void clickContinueButton() {
        getContinueButton().click();
    }
}
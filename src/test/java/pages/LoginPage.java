package pages;

import baseEntities.BasePage;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {
    private final SelenideElement USERNAME_INPUT_LOCATOR = $("#user-name");
    private final SelenideElement PASSWORD_INPUT_LOCATOR = $("#password");
    private final SelenideElement LOGIN_BUTTON_LOCATOR = $("#login-button");
    private final SelenideElement ERROR_MESSAGE_ELEMENT_LOCATOR = $(".error-message-container");

    public LoginPage() {
    }

    @Override
    protected SelenideElement getPageIdentifier() {
        return LOGIN_BUTTON_LOCATOR;
    }

    public SelenideElement getUsernameInput() {
        return USERNAME_INPUT_LOCATOR;
    }

    public SelenideElement getPasswordInput() {
        return PASSWORD_INPUT_LOCATOR;
    }

    public SelenideElement getButton() {
        return LOGIN_BUTTON_LOCATOR;
    }

    public SelenideElement getErrorMessageElement() {
        return ERROR_MESSAGE_ELEMENT_LOCATOR;
    }

    public void setUsernameValue(String value) {
        getUsernameInput().val(value);
    }

    public void setPasswordValue(String value) {
        getPasswordInput().val(value);
    }

    public void clickLoginButton() {
        getButton().click();
    }
}
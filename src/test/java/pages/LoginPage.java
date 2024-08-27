package pages;

import baseEntities.BasePage;
import elements.Button;
import elements.Input;
import elements.UIElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final By EMAIL_INPUT_LOCATOR = By.id("name");
    private final By PASSWORD_INPUT_LOCATOR = By.id("password");
    private static final By LOGIN_BUTTON_LOCATOR = By.id("button_primary");
    private final By ERROR_TEXT_LOCATOR = By.className("error-text");
    private final By ERROR_FIELD_TEXT_LOCATOR = By.className("loginpage-message");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return LOGIN_BUTTON_LOCATOR;
    }

    @Override
    protected String getPagePath() {
        return "";
    }

    public Input getEmailInput() {
        return new Input(pageDriver, EMAIL_INPUT_LOCATOR);
    }

    public Input getPasswordInput() {
        return new Input(pageDriver, PASSWORD_INPUT_LOCATOR);
    }

    public Button getLoginButton() {
        return new Button(pageDriver, LOGIN_BUTTON_LOCATOR);
    }

    public UIElement getErrorTextElement() {
        return new UIElement(pageDriver, ERROR_TEXT_LOCATOR);
    }

    public UIElement getErrorFieldTextElement() {
        return new UIElement(pageDriver, ERROR_FIELD_TEXT_LOCATOR);
    }

    public void setEmailValue(String value) {
        getEmailInput().write(value);
    }

    public void setPasswordValue(String value) {
        getPasswordInput().write(value);
    }

    public void clickLogin() {
        getLoginButton().click();
    }
}

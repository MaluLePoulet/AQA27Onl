package pages;

import baseEntities.BasePage;
import com.codeborne.selenide.SelenideElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {
    private Logger logger = LogManager.getLogger(LoginPage.class);

    private final By EMAIL_INPUT_LOCATOR = By.id("name");
    private final By PASSWORD_INPUT_LOCATOR = By.id("password");
    private static final By LOGIN_BUTTON_LOCATOR = By.id("button_primary");
    private final By ERROR_TEXT_LOCATOR = By.className("error-text");
    private final By ERROR_FIELD_TEXT_LOCATOR = By.className("loginpage-message");

    @Override
    protected By getPageIdentifier() {
        return LOGIN_BUTTON_LOCATOR;
    }

    @Override
    protected String getPagePath() {
        return "/";
    }

    public SelenideElement getEmailInput() {
        return $(EMAIL_INPUT_LOCATOR);
    }

    public SelenideElement getPasswordInput() {
        return $(PASSWORD_INPUT_LOCATOR);
    }

    public SelenideElement getLoginButton() {
        return $(LOGIN_BUTTON_LOCATOR);
    }

    public SelenideElement getErrorTextElement() {
        return $(ERROR_TEXT_LOCATOR);
    }

    public void setEmailValue(String value) {
        logger.info(value);
        getEmailInput().setValue(value);
    }

    public void setPasswordValue(String value) {
        logger.info(value);
        getPasswordInput().val(value);
    }

    public void clickLogin() {
        getLoginButton().click();
    }
}

package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    private final By USERNAME_INPUT_LOCATOR = By.id("user-name");
    private final By PASSWORD_INPUT_LOCATOR = By.id("password");
    private final By LOGIN_BUTTON_LOCATOR = By.id("login-button");
    private final By ERROR_MESSAGE_ELEMENT_LOCATOR = By.className("error-message-container");


    public LoginPage(WebDriver driver) {
        super(driver);
    }


    @Override
    protected By getPageIdentifier() {
        return LOGIN_BUTTON_LOCATOR;
    }

    public WebElement getUsernameInput() {
        return pageDriver.findElement(USERNAME_INPUT_LOCATOR);
    }

    public WebElement getPasswordInput() {
        return pageDriver.findElement(PASSWORD_INPUT_LOCATOR);
    }

    public WebElement getButton() {
        return pageDriver.findElement(LOGIN_BUTTON_LOCATOR);
    }

    public WebElement getErrorMessageElement() {
        return pageDriver.findElement(ERROR_MESSAGE_ELEMENT_LOCATOR);
    }

    public void setUsernameValue(String value) {
        getUsernameInput().sendKeys(value);
    }

    public void setPasswordValue(String value) {
        getPasswordInput().sendKeys(value);
    }

    public void clickLoginButton() {
        getButton().click();
    }
}

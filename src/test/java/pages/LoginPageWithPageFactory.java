package pages;

import baseEntities.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageWithPageFactory extends BasePage {
    @FindBy(id = "name")
    public WebElement emailInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(id = "button_primary")
    public WebElement loginButton;

    @FindBy(className = "error-text")
    public WebElement errorText;

    @FindBy(className = "loginpage-message")
    public WebElement errorFieldText;

    public LoginPageWithPageFactory(WebDriver driver) {
        super(driver);
    }

    @Override
    protected WebElement getPageIdentifier() {
        return loginButton;
    }

    public void setEmailValue(String value) {
        emailInput.sendKeys(value);
    }

    public void setPasswordValue(String value) {
        passwordInput.sendKeys(value);
    }

    public void clickLogin() {
        loginButton.click();
    }
}

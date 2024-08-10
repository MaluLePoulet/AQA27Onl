package pages.checkout;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.TopMenuPage;

public class CheckoutInformationPage extends BasePage {
    private final By FIRST_NAME_INPUT_LOCATOR = By.id("first-name");
    private final By LAST_NAME_INPUT_LOCATOR = By.id("last-name");
    private final By ZIP_CODE_INPUT_LOCATOR = By.id("postal-code");
    private final By CONTINUE_BUTTON_LOCATOR = By.id("continue");
    public TopMenuPage topMenuPage;


    public CheckoutInformationPage(WebDriver driver) {
        super(driver);

        topMenuPage = new TopMenuPage(driver);
    }


    @Override
    protected By getPageIdentifier() {
        return CONTINUE_BUTTON_LOCATOR;
    }

    public WebElement getFirstNameInput() {
        return pageDriver.findElement(FIRST_NAME_INPUT_LOCATOR);
    }

    public WebElement getLastNameInput() {
        return pageDriver.findElement(LAST_NAME_INPUT_LOCATOR);
    }

    public WebElement getZipCodeInput() {
        return pageDriver.findElement(ZIP_CODE_INPUT_LOCATOR);
    }

    public WebElement getContinueButton() {
        return pageDriver.findElement(CONTINUE_BUTTON_LOCATOR);
    }

    public void setFirstNameValue() {
        getFirstNameInput().sendKeys("Limon");
    }

    public void setLastNameValue() {
        getLastNameInput().sendKeys("Limonov");
    }

    public void setZipCodeValue() {
        getZipCodeInput().sendKeys("123456");
    }

    public void clickContinueButton() {
        getContinueButton().click();
    }
}

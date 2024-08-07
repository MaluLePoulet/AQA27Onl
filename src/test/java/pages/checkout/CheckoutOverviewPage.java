package pages.checkout;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutOverviewPage extends BasePage {
    private final By FINISH_BUTTON_LOCATOR = By.id("finish");


    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }


    @Override
    protected By getPageIdentifier() {
        return FINISH_BUTTON_LOCATOR;
    }

    public WebElement getFinishButton() {
        return pageDriver.findElement(FINISH_BUTTON_LOCATOR);
    }

    public void clickFinishButton() {
        getFinishButton().click();
    }
}

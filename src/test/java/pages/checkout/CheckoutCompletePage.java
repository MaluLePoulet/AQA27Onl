package pages.checkout;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.TopMenuPage;

public class CheckoutCompletePage extends BasePage {
    private final By CHECKOUT_COMPLETE_MESSAGE_LOCATOR = By.className("complete-header");
    public TopMenuPage topMenuPage;

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);

        topMenuPage = new TopMenuPage(driver);
    }


    @Override
    protected By getPageIdentifier() {
        return CHECKOUT_COMPLETE_MESSAGE_LOCATOR;
    }

    public WebElement getCheckoutCompleteMessageElement() {
        return pageDriver.findElement(CHECKOUT_COMPLETE_MESSAGE_LOCATOR);
    }
}

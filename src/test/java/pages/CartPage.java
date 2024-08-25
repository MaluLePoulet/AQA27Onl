package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {
    private final By CHECKOUT_BUTTON_LOCATOR = By.id("checkout");
    private final By REMOVED_ITEM_LOCATOR = By.className("removed_cart_item");
    public TopMenuPage topMenuPage;

    public CartPage(WebDriver driver) {
        super(driver);

        topMenuPage = new TopMenuPage(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return CHECKOUT_BUTTON_LOCATOR;
    }

    public WebElement getCheckoutButton() {
        return pageDriver.findElement(CHECKOUT_BUTTON_LOCATOR);
    }

    public WebElement getRemovedItemElement() {
        return pageDriver.findElement(REMOVED_ITEM_LOCATOR);
    }

    public void clickCheckoutButton() {
        getCheckoutButton().click();
    }
}

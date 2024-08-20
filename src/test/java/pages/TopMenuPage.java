package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TopMenuPage extends BasePage {
    private final By SHOPPING_CART_CONTAINER_LOCATOR = By.id("shopping_cart_container");

    public TopMenuPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return null;
    }

    public WebElement getShoppingCartElement() {
        return pageDriver.findElement(SHOPPING_CART_CONTAINER_LOCATOR);
    }

    public void clickShoppingCartElement() {
        getShoppingCartElement().click();
    }
}

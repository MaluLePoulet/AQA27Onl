package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage extends BasePage {
    private static final String pagePath = "inventory.html";
    private final By PRODUCT_SORT_CONTAINER_LOCATOR = By.className("product_sort_container");
    private final By INVENTORY_ITEM_SLB_LOCATOR = By.id("item_4_title_link");
    private final By ADD_TO_CART_SLB_BUTTON_LOCATOR = By.id("add-to-cart-sauce-labs-backpack");
    private final By REMOVE_FROM_CART_SLB_BUTTON_LOCATOR = By.id("remove-sauce-labs-backpack");

    public TopMenuPage topMenuPage;

    public InventoryPage(WebDriver driver) {
        super(driver);

        topMenuPage = new TopMenuPage(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return PRODUCT_SORT_CONTAINER_LOCATOR;
    }

    public WebElement getInventoryItemElement() {
        return pageDriver.findElement(INVENTORY_ITEM_SLB_LOCATOR);
    }

    public WebElement getAddToCartButton() {
        return pageDriver.findElement(ADD_TO_CART_SLB_BUTTON_LOCATOR);
    }

    public WebElement getRemoveFromCartButton() {
        return pageDriver.findElement(REMOVE_FROM_CART_SLB_BUTTON_LOCATOR);
    }

    public void clickAddToCartButton() {
        getAddToCartButton().click();
    }

    public void clickRemoveFromCartButton() {
        getRemoveFromCartButton().click();
    }

    @Override
    public void openPageByUrl(String pagePath) {
        super.openPageByUrl(pagePath);
    }
}

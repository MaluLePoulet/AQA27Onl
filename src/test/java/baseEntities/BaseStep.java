package baseEntities;

import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;
import pages.TopMenuPage;
import pages.checkout.CheckoutCompletePage;
import pages.checkout.CheckoutInformationPage;
import pages.checkout.CheckoutOverviewPage;

public class BaseStep {
    protected LoginPage loginPage;
    protected InventoryPage inventoryPage;
    protected TopMenuPage topMenuPage;
    protected CartPage cartPage;
    protected CheckoutInformationPage checkoutInformationPage;
    protected CheckoutOverviewPage checkoutOverviewPage;
    protected CheckoutCompletePage checkoutCompletePage;


    public BaseStep() {
        loginPage = new LoginPage();
        inventoryPage = new InventoryPage();
        topMenuPage = new TopMenuPage();
        cartPage = new CartPage();
        checkoutInformationPage = new CheckoutInformationPage();
        checkoutOverviewPage = new CheckoutOverviewPage();
        checkoutCompletePage = new CheckoutCompletePage();
    }
}
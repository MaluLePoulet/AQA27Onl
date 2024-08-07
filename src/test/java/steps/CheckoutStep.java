package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.checkout.CheckoutCompletePage;

public class CheckoutStep extends BaseStep {

    public CheckoutStep(WebDriver driver) {
        super(driver);
    }

    public CheckoutCompletePage successfulCheckout() {
        checkout();
        checkoutOverviewPage.clickFinishButton();
        return checkoutCompletePage;
    }

    private void checkout() {
        checkoutInformationPage.setFirstNameValue();
        checkoutInformationPage.setLastNameValue();
        checkoutInformationPage.setZipCodeValue();
        checkoutInformationPage.clickContinueButton();
    }
}

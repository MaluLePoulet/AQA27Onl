package steps;

import baseEntities.BaseStep;
import pages.checkout.CheckoutCompletePage;

public class CheckoutStep extends BaseStep {

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

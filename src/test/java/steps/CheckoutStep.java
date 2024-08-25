package steps;

import baseEntities.BaseStep;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.checkout.CheckoutCompletePage;

public class CheckoutStep extends BaseStep {

    public CheckoutStep(WebDriver driver) {
        super(driver);
    }

    @Step(value = "Successful checkout")
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

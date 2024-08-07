package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.InventoryPage;
import pages.LoginPage;

public class UserStep extends BaseStep {

    public UserStep(WebDriver driver) {
        super(driver);
    }

    public InventoryPage successfulLogin(String username, String password) {
        login(username, password);
        return inventoryPage;
    }

    public LoginPage incorrectLogin(String username, String password) {
        login(username, password);
        return loginPage;
    }

    private void login(String username, String password) {
        loginPage.setUsernameValue(username);
        loginPage.setPasswordValue(password);
        loginPage.clickLoginButton();
    }
}

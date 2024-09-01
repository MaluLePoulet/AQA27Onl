package steps;

import baseEntities.BaseStep;
import pages.InventoryPage;
import pages.LoginPage;

public class UserStep extends BaseStep {

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

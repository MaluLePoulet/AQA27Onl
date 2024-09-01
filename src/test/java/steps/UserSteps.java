package steps;

import baseEntities.BaseStep;
import models.User;
import pages.DashboardPage;
import pages.LoginPage;

public class UserSteps extends BaseStep {

    public DashboardPage successfulLogin(User user) {
        login(user);

        return new DashboardPage();
    }

    public LoginPage incorrectLogin(User user) {
        login(user);
        return new LoginPage();
    }

    private void login(User user) {
        loginPage.setEmailValue(user.getUsername());
        loginPage.setPasswordValue(user.getPassword());
        loginPage.clickLogin();
    }
}

package steps;

import baseEntities.BaseStep;
import io.qameta.allure.Step;
import models.User;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.LoginPage;

import static org.bouncycastle.cms.RecipientId.password;

public class UserSteps extends BaseStep {

    public UserSteps(WebDriver driver) {
        super(driver);
    }

    @Step(value = "Успешный логин")
    public DashboardPage successfulLogin(User user) {
        login(user);

        return new DashboardPage(driver);
    }

    @Step(value = "Некорректный логин")
    public LoginPage incorrectLogin(User user) {
        login(user);
        return new LoginPage(driver);
    }

    private void login(User user) {
        loginPage = new LoginPage(driver);

        loginPage.setEmailValue(user.getUsername());
        loginPage.setPasswordValue(user.getPassword());
        loginPage.clickLogin();
    }
}

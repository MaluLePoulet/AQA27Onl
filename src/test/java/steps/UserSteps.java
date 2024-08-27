package steps;

import baseEntities.BaseStep;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.LoginPage;

public class UserSteps extends BaseStep {

    public UserSteps(WebDriver driver) {
        super(driver);
    }

    @Step(value = "Успешный логин")
    public DashboardPage successfulLogin(String username, String password) {
        login(username, password);
        return new DashboardPage(driver);
    }

    @Step(value = "Некорректный логин")
    public LoginPage incorrectLogin(String username, String password) {
        login(username, password);
        return new LoginPage(driver);
    }

    private void login(String username, String password) {
        loginPage = new LoginPage(driver);

        loginPage.setEmailValue(username);
        loginPage.setPasswordValue(password);
        loginPage.clickLogin();
    }
}

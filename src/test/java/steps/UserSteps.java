package steps;

import baseEntities.BaseStep;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.LoginPageWithPageFactory;

public class UserSteps extends BaseStep {

    public UserSteps(WebDriver driver) {
        super(driver);
    }

    @Step(value = "Успешный логин")
    public DashboardPage successfulLogin(String username, String password) {
        login(username, password);
        return dashboardPage;
    }

    @Step(value = "Некорректный логин")
    public LoginPageWithPageFactory incorrectLogin(String username, String password) {
        login(username, password);
        return loginPageWithPageFactory;
    }

    private void login(String username, String password) {
        loginPageWithPageFactory.setEmailValue(username);
        loginPageWithPageFactory.setPasswordValue(password);
        loginPageWithPageFactory.clickLogin();
    }
}

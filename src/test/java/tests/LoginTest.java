package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import utils.Director;


public class LoginTest extends BaseTest {

    @Test
    //пример, как можно делать, но будет много дубликата
    public void successfulLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setEmailValue(ReadProperties.username());
        loginPage.setPasswordValue(ReadProperties.password());
        loginPage.clickLogin();

        DashboardPage dashboardPage = new DashboardPage(driver);
        Assert.assertTrue(dashboardPage.isPageOpen());
    }

    //пример ос степами
    @Test
    public void shortSuccessfulLoginTest() {
        Assert.assertTrue
                (userSteps.successfulLogin(admin).isPageOpen());
    }

    @Test
    public void incorrectEmailLoginTest() {
        Assert.assertEquals(userSteps.incorrectLogin(Director.getUserWithIncorrectUsername())
                        .getErrorTextElement().getText(),
                "Email/Login or Password is incorrect. Please try again.",
                "Неверное сообщение об ошибке");

    }
}

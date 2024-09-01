package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;


public class LoginTest extends BaseTest {

    @Test
    public void successfulLoginTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.setEmailValue(ReadProperties.username());
        loginPage.setPasswordValue(ReadProperties.password());
        loginPage.clickLogin();

        DashboardPage dashboardPage = new DashboardPage();
        Assert.assertTrue(dashboardPage.isPageOpen());
    }

    @Test
    public void shortSuccessfulLoginTest() {
        Assert.assertTrue
                (userSteps.successfulLogin(admin)
                        .isPageOpen());
    }

    @Test
    public void incorrectEmailLoginTest() {
        User incorrectEmailUser = new User();
        incorrectEmailUser.setUsername(ReadProperties.username());
        incorrectEmailUser.setPassword("shbdhfas");

        Assert.assertEquals(userSteps.incorrectLogin(incorrectEmailUser)
                        .getErrorTextElement().getText(),
                "Email/Login or Password is incorrect. Please try again.",
                "Неверное сообщение об ошибке");
    }

    @Test
    public void incorrectPasswordLoginTest() {
        User incorrectPswUser = new User();
        incorrectPswUser.setUsername(ReadProperties.username());
        incorrectPswUser.setPassword("jfhesbd");
        Assert.assertEquals(userSteps.incorrectLogin(incorrectPswUser)
                        .getErrorTextElement().getText(),
                "Email/Login or Password is incorrect. Please try again.",
                "Неверное сообщение об ошибке");
    }
}

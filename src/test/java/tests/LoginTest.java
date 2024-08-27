package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPageWithPageFactory;


public class LoginTest extends BaseTest {

    @Test
    //пример, как можно делать, но будет много дубликата
    public void successfulLoginTest() {
        LoginPageWithPageFactory loginPageWithPageFactory = new LoginPageWithPageFactory(driver);
        loginPageWithPageFactory.setEmailValue(ReadProperties.username());
        loginPageWithPageFactory.setPasswordValue(ReadProperties.password());
        loginPageWithPageFactory.clickLogin();

        DashboardPage dashboardPage = new DashboardPage(driver);
        Assert.assertTrue(dashboardPage.isPageOpen());
    }

    //пример ос степами
    @Test
    public void shortSuccessfulLoginTest() {
        Assert.assertTrue
                (userSteps.successfulLogin(ReadProperties.username(), ReadProperties.password()).isPageOpen());
    }

    @Test
    public void incorrectEmailLoginTest() {
        Assert.assertEquals(userSteps.incorrectLogin
                        ("hdfgds", ReadProperties.password()).errorFieldText.getText(),
                "Email/Login or Password is incorrect. Please try again.",
                "Неверное сообщение об ошибке");
    }

    @Test
    public void incorrectPasswordLoginTest() {
        Assert.assertEquals(userSteps.incorrectLogin
                        (ReadProperties.username(), "ahsdjas").errorText.getText(),
                "Email/Login or Password is incorrect. Please try again.",
                "Неверное сообщение об ошибке");
    }
}

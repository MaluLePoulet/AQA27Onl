package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void successfulLoginStandardUserTest() {
        Assert.assertTrue
                (userStep.successfulLogin(ReadProperties.usernameStandard(), ReadProperties.password()).isPageOpen());
    }

    @Test
    public void successfulLoginProblemUserTest() {
        Assert.assertTrue
                (userStep.successfulLogin(ReadProperties.usernameProblem(), ReadProperties.password()).isPageOpen());
    }

    @Test
    public void successfulLoginPerformanceGlitchUserTest() {
        Assert.assertTrue
                (userStep.successfulLogin(ReadProperties.usernamePerformanceGlitch(), ReadProperties.password()).isPageOpen());
    }

    @Test
    public void successfulLoginErrorUserTest() {
        Assert.assertTrue
                (userStep.successfulLogin(ReadProperties.usernameError(), ReadProperties.password()).isPageOpen());
    }

    @Test
    public void successfulLoginVisualUserTest() {
        Assert.assertTrue
                (userStep.successfulLogin(ReadProperties.usernameVisual(), ReadProperties.password()).isPageOpen());
    }

    @Test
    public void lockedOutUserLoginTest() {
        Assert.assertEquals
                (userStep.incorrectLogin(ReadProperties.usernameLockedOut(), ReadProperties.password()).getErrorMessageElement().getText(),
                        "Epic sadface: Sorry, this user has been locked out.", "Неверное сообщение об ошибке");

    }

    @Test
    public void incorrectPasswordTest() {
        Assert.assertEquals
                (userStep.incorrectLogin(ReadProperties.usernameStandard(), "bhfhgdjs").getErrorMessageElement().getText(),
                        "Epic sadface: Username and password do not match any user in this service", "Неверное сообщение об ошибке");

    }
}

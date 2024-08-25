package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(description = "Successful login with standard user test")
    @Description("This is to test if login with standard user is done correctly")
    @Severity(SeverityLevel.BLOCKER)
    public void successfulLoginStandardUserTest() {
        Assert.assertTrue
                (userStep.successfulLogin(ReadProperties.usernameStandard(), ReadProperties.password()).isPageOpen());
    }

    @Test(description = "Successful login with problem user test")
    @Description("This is to test if login with problem user is done correctly")
    public void successfulLoginProblemUserTest() {
        Assert.assertTrue
                (userStep.successfulLogin(ReadProperties.usernameProblem(), ReadProperties.password()).isPageOpen());
    }

    @Test(description = "Successful login with performance glitch user test")
    @Description("This is to test if login with performance glitch user is done correctly")
    public void successfulLoginPerformanceGlitchUserTest() {
        Assert.assertTrue
                (userStep.successfulLogin(ReadProperties.usernamePerformanceGlitch(), ReadProperties.password()).isPageOpen());
    }

    @Test(description = "Successful login with error user test")
    @Description("This is to test if login with error user is done correctly")
    public void successfulLoginErrorUserTest() {
        Assert.assertTrue
                (userStep.successfulLogin(ReadProperties.usernameError(), ReadProperties.password()).isPageOpen());
    }

    @Test(description = "Successful login with visual user test")
    @Description("This is to test if login with visual user is done correctly")
    public void successfulLoginVisualUserTest() {
        Assert.assertTrue
                (userStep.successfulLogin(ReadProperties.usernameVisual(), ReadProperties.password()).isPageOpen());
    }

    @Test(description = "Successful login with locked out user test")
    @Description("This is to test if login with locked out user displays the correct error message")
    public void lockedOutUserLoginTest() {
        Assert.assertEquals
                (userStep.incorrectLogin(ReadProperties.usernameLockedOut(), ReadProperties.password())
                                .getErrorMessageElement().getText(),
                        "Epic sadface: Sorry, this user has been locked out.", "Неверное сообщение об ошибке");

    }

    @Test(description = "Login with incorrect password")
    @Description("This is to test if login with incorrect password displays the correct error message")
    @Severity(SeverityLevel.TRIVIAL)
    public void incorrectPasswordTest() {
        Assert.assertEquals
                (userStep.incorrectLogin(ReadProperties.usernameStandard(), "bhfhgdjs")
                                .getErrorMessageElement().getText(),
                        "Epic sadface: Username and password do not match any user in this service", "Неверное сообщение об ошибке");

    }
}

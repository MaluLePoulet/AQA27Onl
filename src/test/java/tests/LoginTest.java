package tests;

import configuration.ReadProperties;
import org.testng.annotations.Test;
import pages.LoginPage;


public class LoginTest extends BaseTest {

    @Test
    public void successfulLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getEmailInput();
        loginPage.setEmailValue(ReadProperties.username());
        loginPage.setPasswordValue(ReadProperties.password());
        loginPage.clickLogin();
    }
}

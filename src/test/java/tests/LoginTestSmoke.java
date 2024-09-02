package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestSmoke extends BaseTest {

    @Test
    public void shortSuccessfulLoginTest() {
        System.out.println("Smoke test");
        Assert.assertTrue
                (userSteps.successfulLogin(ReadProperties.username(), ReadProperties.password()).isPageOpen());
    }

    @Test
    public void incorrectEmailLoginTest() {
        System.out.println("Smoke test");
        Assert.assertEquals(userSteps.incorrectLogin
                        ("hdfgds", ReadProperties.password()).getErrorTextElement().getText(),
                "Email/Login or Password is incorrect. Please try again.",
                "Неверное сообщение об ошибке");
    }
}

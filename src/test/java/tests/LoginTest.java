package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class LoginTest extends BaseTest {

    @Test
    public void successfulLoginStandardUserTest() {
        Assert.assertTrue
                (userStep.successfulLogin(ReadProperties.usernameStandard(), ReadProperties.password()).isPageOpen());
    }

    @Test
    public void lockedOutUserLoginTest() {
        userStep.incorrectLogin(ReadProperties.usernameLockedOut(), ReadProperties.password())
                .getErrorMessageElement()
                .shouldBe(visible)
                .shouldHave(text("Epic sadface: Sorry, this user has been locked out."));
    }
}
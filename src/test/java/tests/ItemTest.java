package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;

public class ItemTest extends BaseTest {

    @BeforeMethod
    public void login() {
        userStep.successfulLogin(ReadProperties.usernameStandard(), ReadProperties.password());
    }

    @Test
    public void addItemToCartTest() {
        itemStep.addItemToCart().getInventoryItemElement()
                .shouldBe(visible)
                .shouldHave(text("Sauce Labs Backpack"));
    }

    @Test
    public void removeItemFromCartTest() {
        //itemStep.addItemToCart(); если выполнять через mvn clean test, тогда эта строка не нужна, если выполнять отдельно этот тест, тогда нужна
        itemStep.removeItemFromCart().getRemovedItemElement()
                .shouldNotBe(visible);
    }
}
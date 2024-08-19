package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContextMenuTest extends BaseTest {

    @Test
    public void contextMenuTest() {
        driver.get("https://the-internet.herokuapp.com/context_menu");

        Actions actions = new Actions(driver);

        WebElement contextMenu = waitsService.elementToBeClickable(By.id("hot-spot"));

        actions
                .moveToElement(contextMenu)
                .contextClick()
                .build()
                .perform();

        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "You selected a context menu");
        alert.accept();
    }
}

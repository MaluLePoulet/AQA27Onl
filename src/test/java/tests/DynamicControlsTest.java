package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicControlsTest extends BaseTest {

    @Test
    public void dynamicControlsTest() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebElement checkbox = waitsService.waitVisibilityOf(By.id("checkbox"));

        waitsService.elementToBeClickable(By.xpath("//button[text() = 'Remove']")).click();
        waitsService.waitVisibilityOf(By.id("message"));
        Assert.assertTrue(waitsService.invisibilityOf(checkbox));

        WebElement inputField = waitsService.waitVisibilityOf(By.xpath("//*[@type='text']"));
        //Assert.assertFalse(inputField.isEnabled());
        Assert.assertTrue(waitsService.attributeToBe(inputField, "disabled", "true"));

        waitsService.elementToBeClickable(By.xpath("//button[text() = 'Enable']")).click();
        waitsService.waitVisibilityOf(By.id("message"));
        Assert.assertTrue(inputField.isEnabled());
    }
}

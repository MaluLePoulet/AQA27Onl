package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertTest extends BaseTest {

    @Test
    public void infoAlertTest() { // как пример, что можно добавить обработчик, но так не надо делать, тесты должны быть не программами
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");

        WebElement button = driver.findElement(By.xpath("//button[. = 'Click for JS Confirm']"));

        driver.findElement(By.xpath("//button[. = 'Click for JS Alert']")).click();

        if (waitsService.alertIsPresent() != null) {
            Alert alert = driver.switchTo().alert();
            Assert.assertEquals(alert.getText(), "I am a JS Alert");
            alert.accept();
        }
        button.click();
    }

    @Test
    public void confirmAlertTest() { // нужно так со всеми алертами
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//button[. = 'Click for JS Confirm']")).click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "I am a JS Confirm");
        alert.dismiss();

        Assert.assertEquals(waitsService.waitVisibilityOf(By.id("result")).getText(), "You clicked: Cancel");
    }

    @Test
    public void promptAlertTest() {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//button[. = 'Click for JS Prompt']")).click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "I am a JS prompt");
        alert.sendKeys("Everything is OK!");
        alert.accept();
    }

}

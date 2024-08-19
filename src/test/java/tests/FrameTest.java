package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.Duration;

public class FrameTest extends BaseTest {

    @Test
    public void iFrameTest() {
        driver.get("http://the-internet.herokuapp.com/iframe");

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10));

        WebElement button = driver.findElement(By.cssSelector("button[aria-label='Bold']")); // принадлежит original html

        //driver.switchTo().frame(0); // переключение по индексу
        //driver.switchTo().frame("mce_0_ifr"); // переключение по name или id

        WebElement frame = driver.findElement(By.cssSelector("iframe.tox-edit-area__iframe"));
        driver.switchTo().frame(frame); // переключение на основании WebElementа


        WebElement element = driver.findElement(By.id("tinymce")); // принадлежит frame html

        driver.switchTo().parentFrame(); // вернет на 1 уровень вверх
        driver.switchTo().defaultContent(); // перемещает сразу в orginal html

        WebElement button1 = driver.findElement(By.cssSelector("button[aria-label='Bold']")); // принадлежит original html
    }
}

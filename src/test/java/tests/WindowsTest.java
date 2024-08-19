package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WindowsTest extends BaseTest {

    @Test
    public void windowsTest() {
        driver.get("http://the-internet.herokuapp.com/windows");

        String originalWindowHandle = driver.getWindowHandle();
        System.out.println(driver.getWindowHandles().size());

        driver.findElement(By.linkText("Click Here")).click();
        System.out.println(driver.getWindowHandles().size());

        Set<String> windowHandlesSet = driver.getWindowHandles();
        List<String> windowHandlesList = new ArrayList<>(windowHandlesSet);

        driver.switchTo().window(windowHandlesList.get(1));
        WebElement elementNewTab = driver.findElement(By.xpath("//h3[text() = 'New Window']"));

        driver.close(); // закрытие вкладки

        driver.switchTo().window(originalWindowHandle); // переключаем на основную вкладку, пот. селениум автоматически не переключается даже после закрытия вкладки

        Assert.assertTrue(driver.findElement(By.linkText("Click Here")).isDisplayed());

    }
}

package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class FileUploadTest extends BaseTest {

    @Test
    public void fileUploadTest() {
        driver.get("https://the-internet.herokuapp.com/upload");

        WebElement fileUploadField = waitsService.presenceOfElementLocated(By.id("file-upload"));

        //String pathToFile = FileUploadTest.class.getClassLoader()
        //     .getResource("data" + File.separator + "download.jpeg")
        //     .getPath().replace("%20"," "); // работает у меня, т.к. в начале пути проблемы с пробелом, но у вас (в теории) должен сработать второй
        String pathToFile = FileUploadTest.class.getClassLoader()
                .getResource("data" + File.separator + "download.jpeg")
                .getPath();

        fileUploadField.sendKeys(pathToFile);
        waitsService.elementToBeClickable(By.id("file-submit")).click();

        Assert.assertEquals(waitsService.waitVisibilityOf(By.id("uploaded-files")).getText(), "download.jpeg");
    }
}

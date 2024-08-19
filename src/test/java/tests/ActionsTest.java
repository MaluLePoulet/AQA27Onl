package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class ActionsTest extends BaseTest {

    @Test
    public void hoverTest() {
        driver.get("http://the-internet.herokuapp.com/hovers");

        Actions actions = new Actions(driver);

        List<WebElement> targetElements = waitsService.visibilityOfAllElementsLocatedBy(By.className("figure"));

        actions
                .moveToElement(targetElements.get(0))
                .pause(Duration.ofSeconds(1)) // просто посмотреть
                .click(waitsService.presenceOfElementLocated(By.cssSelector("[href='/users/1']")))
                .build()
                .perform();

        Assert.assertTrue(waitsService.waitVisibilityOf(By.xpath("//h1[text() = 'Not Found']")).isDisplayed());
    }

    @Test
    public void dragAndDropTest() {
        driver.get("http://the-internet.herokuapp.com/drag_and_drop");

        Actions actions = new Actions(driver);

        WebElement source = waitsService.waitVisibilityOf(By.id("column-a"));
        WebElement target = waitsService.waitVisibilityOf(By.id("column-b"));

        actions
                .dragAndDrop(source, target)
                .pause(Duration.ofSeconds(2)) // просто посмотреть
                .build()
                .perform();

        actions
                .moveToElement(source)
                .clickAndHold()
                .moveToElement(target)
                .release()
                .build()
                .perform();
    }

    @Test
    public void uploadFileTest() {
        driver.get("http://the-internet.herokuapp.com/upload");

        WebElement fileUploadElement = waitsService.presenceOfElementLocated(By.id("file-upload"));
        //String pathToFile ="/Users/malutka/Library/Mobile Documents/com~apple~CloudDocs/projectsjava/AQA27Onl/src/test/resources/data/download.jpeg";
        String pathToFile = ActionsTest.class.getClassLoader().getResource("data" + File.separator + "download.jpeg").getPath().replace("%20", " ");
        System.out.println(pathToFile);

        fileUploadElement.sendKeys(pathToFile);
        waitsService.elementToBeClickable(By.id("file-submit")).click();
    }
}

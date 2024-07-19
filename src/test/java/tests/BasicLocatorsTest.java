package tests;

import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.BrowsersService;

public class BasicLocatorsTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new BrowsersService().getDriver();
    }

    @AfterMethod
    public void shutDown() {
        driver.quit();
    }

    @Test
    public void basicLocatorsTest_1() {
        driver.get(ReadProperties.getUrl());

        // Find element by ID
        driver.findElement(By.id("name")).sendKeys(ReadProperties.username());

        // Find element by Name
        driver.findElement(By.name("password")).sendKeys(ReadProperties.password());

        // Find element by TagName
        driver.findElement(By.tagName("button")).click();
    }

    @Test
    public void basicLocatorsTest_2() {
        driver.get(ReadProperties.getUrl());

        // Find element by linkText
        driver.findElement(By.linkText("Forgot your password?")).click();

        // Find element by className
        driver.findElement(By.className("passwordpage-button")).click();

        // Find element by partialLinkText
        driver.findElement(By.partialLinkText("your password?")).click();
    }
}
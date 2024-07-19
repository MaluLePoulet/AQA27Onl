package tests;

import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.BrowsersService;

public class Task {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new BrowsersService().getDriver();
    }

    @AfterMethod
    public void shutDown() {
        driver.quit();
    }

    @Test
    public void validateSauceDemo() throws InterruptedException {
        driver.get(ReadProperties.getUrl());

        driver.findElement(By.id("user-name")).sendKeys(ReadProperties.username());
        driver.findElement(By.name("password")).sendKeys(ReadProperties.password());
        driver.findElement(By.className("btn_action")).submit();

        WebElement productSortDropDown = driver.findElement(By.tagName("select"));
        Select selectSort = new Select(productSortDropDown);
        selectSort.selectByVisibleText("Price (low to high)");

        driver.findElement(By.linkText("Sauce Labs Onesie")).click();
        driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();

        driver.findElement(By.xpath("//button[contains(@style,'opacity')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[contains(text(),'Items')]")).click();

        driver.findElement(By.xpath("//*[text()='Sauce Labs Bolt T-Shirt']//ancestor::a")).click();
        driver.findElement(By.xpath("//*[@class='inventory_details_desc_container']/descendant::button")).click();

        driver.findElement(By.xpath("//span/following::button[contains(text(),'Open Menu')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div/preceding::nav/a[@id='inventory_sidebar_link']")).click();
        Thread.sleep(3000);
        driver.findElement(By.partialLinkText("Backpack")).click();
        driver.findElement(By.cssSelector(".btn_primary")).click();
        driver.findElement(By.xpath("//div[@id='shopping_cart_container' and @class='shopping_cart_container']")).click();
        driver.findElement(By.cssSelector(".btn_action.checkout_button")).click();
        driver.findElement(By.cssSelector(".checkout_buttons .cart_cancel_link")).click();

        driver.findElement(By.cssSelector("#item_4_title_link")).click();
        driver.findElement(By.cssSelector("button.btn_secondary")).click();
        driver.findElement(By.cssSelector("path")).click();

        driver.findElement(By.cssSelector("[class='btn_action checkout_button']")).click();
        driver.findElement(By.cssSelector("[placeholder~=First]")).sendKeys("Limon");
        driver.findElement(By.cssSelector("[id|=last]")).sendKeys("Ivanov");
        driver.findElement(By.cssSelector("[id^=po]")).sendKeys("Qwe123");
        driver.findElement(By.cssSelector("[value$=NUE]")).click();

        WebElement resultNameItem1 = driver.findElement(By.xpath("//a[@id='item_2_title_link']"));
        WebElement resultNameItem2 = driver.findElement(By.cssSelector("[id*='1']"));
        WebElement resultTotal = driver.findElement(By.xpath("//div[text()='Total: $']"));


        Assert.assertTrue(driver.findElement(By.xpath("//a/parent::div/child::a[text()='FINISH']")).isDisplayed());

        Assert.assertEquals(resultNameItem1.getText(), "Sauce Labs Onesie");
        Assert.assertEquals(resultNameItem2.getText(), "Sauce Labs Bolt T-Shirt");
        Assert.assertEquals(resultTotal.getText(), "Total: $25.90");
    }
}

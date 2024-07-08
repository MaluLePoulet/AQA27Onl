package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.BrowsersService;

public class SmokeTest {
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
    public void validateSKF() {
        driver.get("https://bymed.top/calc/%D1%81%D0%BA%D1%84-2148");

        WebElement consentButton = driver.findElement(By.cssSelector(".fc-button.fc-cta-consent.fc-primary-button"));
        consentButton.click();

        driver.switchTo().frame(1);

        WebElement genderDropDown = driver.findElement(By.id("sex"));
        Select selectGender = new Select(genderDropDown);
        selectGender.selectByVisibleText("Женский");

        WebElement ageField = driver.findElement(By.id("age"));
        WebElement creatinineField = driver.findElement(By.id("cr"));
        WebElement weightFeild = driver.findElement(By.id("mass"));
        WebElement heightField = driver.findElement(By.id("grow"));
        WebElement button = driver.findElement(By.tagName("button"));

        ageField.sendKeys("38");
        creatinineField.sendKeys("80");
        weightFeild.sendKeys("55");
        heightField.sendKeys("163");
        button.click();

        WebElement resultMdrd = driver.findElement(By.id("mdrd"));
        WebElement resultCKD = driver.findElement(By.id("ckd_epi"));
        WebElement resultCockroftGault = driver.findElement(By.id("cge"));

        Assert.assertEquals(resultMdrd.getText(), "69.63 мл/мин/1.73м2 - Незначительно сниженный уровень СКФ (C2)");
        Assert.assertEquals(resultCKD.getText(), "80.57 мл/мин/1.73м2 - Незначительно сниженный уровень СКФ (C2)");
        Assert.assertEquals(resultCockroftGault.getText(), "73.18 мл/мин");

    }

    @Test
    public void validateEFHC() {
        driver.get("https://kermi-fko.ru/raschety/Calc-Rehau-Solelec.aspx");

        WebElement widthField = driver.findElement(By.id("el_f_width"));
        WebElement lengthField = driver.findElement(By.id("el_f_lenght"));
        WebElement button = driver.findElement(By.name("button"));

        WebElement roomTypeDropDown = driver.findElement(By.id("room_type"));
        Select selectRoomType = new Select(roomTypeDropDown);
        selectRoomType.selectByVisibleText("Остекленная лоджия или теплый балкон");

        WebElement heatingTypeDropDown = driver.findElement(By.id("heating_type"));
        Select selectHeatingType = new Select(heatingTypeDropDown);
        selectHeatingType.selectByValue("3");

        widthField.sendKeys("2");
        lengthField.sendKeys("3");
        button.click();

        WebElement resultFloorCablePower = driver.findElement(By.id("floor_cable_power"));
        WebElement resultSpecFloorCablePower = driver.findElement(By.id("spec_floor_cable_power"));
        Assert.assertEquals(resultFloorCablePower.getAttribute("value"), "572");
        Assert.assertEquals(resultSpecFloorCablePower.getAttribute("value"), "95");
    }

    @Test
    public void validateLaminateCalc() throws InterruptedException {
        driver.get("https://calc.by/building-calculators/laminate.html");
        Thread.sleep(3000);
        WebElement consentButton = driver.findElement(By.xpath("//span[text()='DISAGREE']"));
        consentButton.click();

        WebElement roomLengthField = driver.findElement(By.id("ln_room_id"));
        WebElement roomWidthField = driver.findElement(By.id("wd_room_id"));
        WebElement laminateLengthField = driver.findElement(By.id("ln_lam_id"));
        WebElement laminateWidthField = driver.findElement(By.id("wd_lam_id"));
        WebElement directionLaminateRadioButton = driver.findElement(By.id("direction-laminate-id1"));
        WebElement calcButton = driver.findElement(By.className("calc-btn-div"));

        WebElement layingMethodField = driver.findElement(By.id("laying_method_laminate"));
        Select selectLayingMethod = new Select(layingMethodField);
        selectLayingMethod.selectByVisibleText("со смещение на 1/3 длины");

        roomLengthField.clear();
        roomWidthField.clear();
        laminateLengthField.clear();
        laminateWidthField.clear();

        roomLengthField.sendKeys("500");
        roomWidthField.sendKeys("400");
        laminateLengthField.sendKeys("2000");
        laminateWidthField.sendKeys("200");
        directionLaminateRadioButton.click();
        calcButton.click();
        Thread.sleep(3000);

        WebElement amountOfLaminateNeeded = driver.findElement(By.xpath("//div[text()='Требуемое количество досок ламината: ']"));
        WebElement amountOfPacksNeeded = driver.findElement(By.xpath("//div[text()='Количество упаковок ламината: ']"));
        Assert.assertEquals(amountOfLaminateNeeded.getText(), "Требуемое количество досок ламината: 52");
        Assert.assertEquals(amountOfPacksNeeded.getText(), "Количество упаковок ламината: 7");
    }
}

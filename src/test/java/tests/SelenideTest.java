package tests;

import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.codeborne.selenide.testng.SoftAsserts;
import configuration.ReadProperties;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byTextCaseInsensitive;
import static com.codeborne.selenide.Selenide.*;

@Listeners(SoftAsserts.class)
public class SelenideTest {

    @BeforeSuite
    public void setUpBrowser() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.baseUrl = ReadProperties.getUrl();

        //Configuration.browser = ReadProperties.browserName();
        Configuration.browser = Browsers.CHROME;
        Configuration.headless = false;
        Configuration.fastSetValue = true;
        Configuration.assertionMode = AssertionMode.SOFT;
        //Configuration.pageLoadTimeout = 30000;
        //Configuration.timeout = ReadProperties.timeout() * 1000;

        // Set browser size
/*
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        System.out.println(width + "x" + height);
        Configuration.browserSize = width + "x" + height;
*/
    }

    @BeforeMethod
    public void openBrowser() {
        //open(ReadProperties.getUrl());
        open("/");
        WebDriverRunner.driver().getWebDriver().manage().window().maximize();
    }

    @Test
    public void simpleTest() {
        $(By.id("name")).setValue(ReadProperties.username());
        $("#password").setValue(ReadProperties.password());
        $("#button_primary").click();

        //Assert.assertEquals($("[data-testid='testCaseContentHeaderTitle']").text(), "All Projects");

        $("[data-testid='testCaseContentHeaderTitle']")
                .shouldBe(visible)
                .shouldHave(text("All Projects"));

        open("index.php?/admin/projects/overview");

        $$(By.className("hoverSensitive"))
                .shouldHave(size(7))
                .find(text("Aerodynamic Rubber Car"))
                .find(By.tagName("a"))
                .click();

        $("#announcement_display")
                .should(exist, Duration.ofSeconds(3))
                .shouldBe(visible)
                .shouldHave(text("Wait a minute. Wait a minute, Doc. Ah... Are you telling me that you built a time machine... out of a DeLorean?"));

        $("#announcement_display").val("New Value");
    }

    @Test
    public void simpleTest1() {
        SelenideElement username = $(By.id("name"));
        username.setValue(ReadProperties.username());
        $("#password").setValue(ReadProperties.password());
        $("#button_primary").click();

        //Assert.assertEquals($("[data-testid='testCaseContentHeaderTitle']").text(), "All Projects");

        $("[data-testid='testCaseContentHeaderTitle']")
                .shouldBe(visible)
                .shouldHave(text("All Projects"));

        open("index.php?/admin/projects/overview");

        ElementsCollection elements = $$(By.className("hoverSensitive"));

        elements
                .shouldHave(size(7))
                .find(text("Aerodynamic Rubber Car"))
                .find(By.tagName("a"))
                .click();

        $("#announcement_display")
                .should(exist, Duration.ofSeconds(3))
                .shouldBe(visible)
                .shouldHave(text("Wait a minute. Wait a minute, Doc. Ah... Are you telling me that you built a time machine... out of a DeLorean?"));

        $("#announcement_display").val("New Value");
    }

    @Test
    public void selenideUploadTest() {
        open("https://the-internet.herokuapp.com/upload");

        String pathToFile = SelenideTest.class.getClassLoader()
           .getResource("data" + File.separator + "download.jpeg")
           .getPath().replace("%20"," ");

        $("#file-upload")
                .uploadFile(new File(pathToFile));
        $("#file-upload")
                .submit();
        sleep(2000);
    }

    @Test
    public void selenideDownloadTest() {
        open("https://the-internet.herokuapp.com/download");

        String uri = $("#content a").download().toURI().toString();
        sleep(2000);

        System.out.println(uri);

        SelenideElement element1 = $(byText("some-file.txt"));
        SelenideElement element2 = $(byTextCaseInsensitive("linkedin post_ne_ashrav.png"));

        SelenideElement parent = element1.parent();
    }
}

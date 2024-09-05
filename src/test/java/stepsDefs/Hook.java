package stepsDefs;

import baseEntities.BaseTest;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import services.BrowsersService;

public class Hook extends BaseTest {
    private BaseTest baseTest;

    public Hook(BaseTest baseTest) {
        this.baseTest = baseTest;
    }

    @BeforeAll()
    public static void initBrowser() {
        driver = new BrowsersService().getDriver();
    }

    @AfterAll()
    public static void closeBrowser() {
        driver.quit();
    }
}
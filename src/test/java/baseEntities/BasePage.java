package baseEntities;

import configuration.ReadProperties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public abstract class BasePage {
    private Logger logger = LogManager.getLogger(this);

    protected final int WAIT_FOR_PAGE_READY_IN_SECONDS = 30;

    public BasePage() {
    }

    protected void load() {
        open(ReadProperties.getUrl() + getPagePath());
    }

    protected abstract By getPageIdentifier();
    protected abstract String getPagePath();

    public boolean isPageOpen() {
        return $(getPageIdentifier())
                .shouldBe(visible, Duration.ofSeconds(WAIT_FOR_PAGE_READY_IN_SECONDS))
                .isDisplayed();
    }
}



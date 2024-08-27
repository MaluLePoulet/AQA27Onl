package baseEntities;

import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected WebDriver pageDriver;
    protected final int WAIT_FOR_PAGE_READY_IN_SECONDS = 60;

    public BasePage(WebDriver driver) {
        this.pageDriver = driver;

        waitForReady();
    }

    protected abstract By getPageIdentifier();

    public boolean isPageOpen() {
        return pageDriver.findElement(getPageIdentifier()).isDisplayed();
    }

    public void openPageByUrl(String pagePath) {
        pageDriver.get(ReadProperties.getUrl() + pagePath);
    }

    public void waitForReady() {
        int tryCount = 0;
        int maxCount = WAIT_FOR_PAGE_READY_IN_SECONDS / ReadProperties.timeout();
        boolean isPageOpenIndicator = isPageOpen();
        while (!isPageOpenIndicator && (tryCount < maxCount)) {
            tryCount++;
            isPageOpenIndicator = isPageOpen();
        }

        if(!isPageOpenIndicator) {
            throw new AssertionError("Page is not open");
        }
    }
}



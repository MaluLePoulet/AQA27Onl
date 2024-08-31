package baseEntities;

import configuration.ReadProperties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected WebDriver pageDriver;

    public BasePage(WebDriver driver) {
        this.pageDriver = driver;
    }

    protected abstract By getPageIdentifier();

    public boolean isPageOpen() {
        return pageDriver.findElement(getPageIdentifier()).isDisplayed();
    }

    public void openPageByUrl(String pagePath) {
        pageDriver.get(ReadProperties.getUrl() + pagePath);
    }
}
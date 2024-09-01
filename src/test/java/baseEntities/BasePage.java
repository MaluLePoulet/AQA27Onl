package baseEntities;

import com.codeborne.selenide.SelenideElement;
import configuration.ReadProperties;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public abstract class BasePage {

    public BasePage() {
    }

    protected abstract SelenideElement getPageIdentifier();

    public boolean isPageOpen() {
        return $(getPageIdentifier()).isDisplayed();
    }

    public void openPageByUrl(String pagePath) {
        open(ReadProperties.getUrl() + pagePath);
    }
}
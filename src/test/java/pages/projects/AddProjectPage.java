package pages.projects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.$;

public class AddProjectPage extends BaseProjectPage {
    private final static String pagePath = "/index.php?/admin/projects/add/1";
    private final By ADD_PROJECT_BUTTON_LOCATOR = By.id("accept");
    private final By PROJECT_TYPE_RADIO_BUTTON_LOCATOR = By.cssSelector("[name='suite_mode']");

    public SelenideElement getAddProjectButton() {
        return $(ADD_PROJECT_BUTTON_LOCATOR);
    }

    public SelenideElement getProjectTypeRadioButton() {
        return $(PROJECT_TYPE_RADIO_BUTTON_LOCATOR);
    }

    public void openPageByUrl() {
        super.load();
    }
}

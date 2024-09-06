package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Checkbox {
    private UIElement uiElement;

    /**
     * @param driver
     * @param by
     */
    public Checkbox(WebDriver driver, By by) {
        uiElement = new UIElement(driver, by);
    }

    private void setFlag(boolean flag) {
        if (!uiElement.isSelected() && flag)
            uiElement.click();
    }

    public void set() {
        setFlag(true);
    }

    public void remove() {
        setFlag(false);
    }

    public boolean isCheckboxSet() {
        return uiElement.isSelected();
    }
}
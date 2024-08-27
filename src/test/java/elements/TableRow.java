package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class TableRow {
    private UIElement rowElement;
    private WebDriver driver;

    public TableRow(WebDriver driver, By by) {
        this.rowElement = new UIElement(driver, by);
        this.driver = driver;
    }

    public TableRow(WebDriver driver, UIElement element) {
        this.rowElement = new UIElement(driver, element);
        this.driver = driver;
    }

    public TableCell getCell(int index) {
        List<UIElement> rows = rowElement.findUIElements(By.tagName("td"));

        return new TableCell(driver, rows.get(index));
    }

}

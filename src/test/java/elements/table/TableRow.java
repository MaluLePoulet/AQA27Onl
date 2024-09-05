package elements.table;

import elements.UIElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class TableRow {
    private UIElement rowElement;
    private WebDriver driver;

    public TableRow(WebDriver driver, By by) {
        this.driver = driver;
        this.rowElement = new UIElement(driver, by);
    }

    public TableRow(WebDriver driver, UIElement element) {
        this.driver = driver;
        this.rowElement = element;
    }

    public TableCell getCell(int index) {
        List<UIElement> rows = rowElement.findUIElements(By.tagName("td"));

        return new TableCell(driver, rows.get(index));
    }
}
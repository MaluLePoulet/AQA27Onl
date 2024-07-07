package services;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleDriver {

    public WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/malutka/Library/Mobile Documents/com~apple~CloudDocs/projectsjava/AQA27Onl/src/test/resources/chromedriver");

        return new ChromeDriver();
    }

}

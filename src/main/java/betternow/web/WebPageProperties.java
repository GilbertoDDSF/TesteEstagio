package betternow.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebPageProperties {

    protected WebDriver browser;

    public WebPageProperties(WebDriver browser) {
        System.setProperty("webdriver.chrome.driver", "src/main/java/drivers/chromedriver.exe");
        if (browser == null) {
            this.browser = new ChromeDriver();
        } else {
            this.browser = browser;

        }
    }

    public void fechar() {
        this.browser.quit();
    }

}


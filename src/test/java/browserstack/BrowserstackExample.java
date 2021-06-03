package browserstack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.URL;

import static java.lang.Thread.sleep;

public class BrowserstackExample {
    public static final String USERNAME = "bsuser71747";
    public static final String AUTOMATE_KEY = "54UQLp7q7rXbeGqixxTs";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    @Test
    public void BrowserstackTest() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("browserName", "iPhone");
        caps.setCapability("device", "iPhone 12 Pro");
        caps.setCapability("realMobile", "true");
        caps.setCapability("os_version", "14");
        caps.setCapability("name", "bsuser71747's First Test");

        WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
        driver.get("https://it-platforma.website/");
        WebElement element = driver.findElement(By.xpath("//input[@type=\"search\"]"));
        element.sendKeys("hello world");
        element.submit();
        sleep(500);
        System.out.println(driver.getCurrentUrl());

        driver.quit();
    }
}
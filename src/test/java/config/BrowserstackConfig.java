package config;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BrowserstackConfig {
    public static final String USERNAME = "bsuser71747";
    public static final String AUTOMATE_KEY = "54UQLp7q7rXbeGqixxTs";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public void setUpConfigBrowserstack() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("browserName", "iPhone");
        caps.setCapability("device", "iPhone 12 Pro");
        caps.setCapability("realMobile", "true");
        caps.setCapability("os_version", "14");
        caps.setCapability("name", "bsuser71747's First Test");

        WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
        WebDriverRunner.setWebDriver(driver);

    }

}

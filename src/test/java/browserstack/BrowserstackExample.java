package browserstack;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import data.ProjectUrls;
import io.qameta.allure.selenide.AllureSelenide;
import logger.CustomLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.logging.Level;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;
import static pages.actions.general.CommonSteps.getAndAttachScreenshot;

public class BrowserstackExample {
    public static final String USERNAME = "bsuser71747";
    public static final String AUTOMATE_KEY = "54UQLp7q7rXbeGqixxTs";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    @Test
    public void BrowserstackTest() throws Exception {
        Configuration.reportsFolder = "target/screenshots";
        Configuration.downloadsFolder = "target/build/downloads";
        Configuration.baseUrl = "";
        Configuration.timeout = 60000;
        Configuration.clickViaJs = true;
        Configuration.pageLoadStrategy = "eager";
        Configuration.proxyEnabled = false;
        DesiredCapabilities dc = new DesiredCapabilities();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        dc.setCapability(ChromeOptions.CAPABILITY, options);
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);
        dc.setCapability("goog:loggingPrefs", logPrefs);
        dc.setCapability("device", "iPhone 12 Pro");
        dc.setCapability("os_version", "14");
        dc.setCapability("browserstack.video", true);
        dc.setCapability("realMobile", true);
        dc.setCapability("acceptSslCerts", true);
        dc.setCapability("browser", "chrome");
        dc.setCapability("browser_version", "latest");
        dc.setCapability("build", "Autotests");
        dc.setCapability("project", "Autotests");
        dc.setCapability("browserstack.console", "errors");
        dc.setCapability("browserstack.networkLogs", true);
        dc.setCapability("browserstack.idleTimeout", "300");
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
        WebDriver driver = new RemoteWebDriver(new URL(URL), dc);
        setWebDriver(driver);
        CustomLogger.logger.info("ok");

//        test
        open(ProjectUrls.IT_PLATFORM_WEBSITE.getUrl());
        getAndAttachScreenshot();
        CustomLogger.logger.info("ok");
    }

}
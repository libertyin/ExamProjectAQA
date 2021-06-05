package config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import logger.CustomLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.logging.Level;

import static global.Global.globalModeDebug;

public class SelenoidConfig {

    public void setUpConfigChrome() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);
        Configuration.startMaximized = true;
        Configuration.browserCapabilities.setCapability("goog:loggingPrefs", logPrefs);
        Configuration.browserCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
        Configuration.browserCapabilities.setCapability("sessionTimeout", "1m");
        Configuration.pageLoadStrategy = "eager";
        Configuration.downloadsFolder = "target/build/downloads";
        Configuration.reportsFolder = "target/screenshots";
        Configuration.pageLoadTimeout = 10000;
        Configuration.timeout = 10000;
        Configuration.browser = "Chrome";
        Configuration.browserVersion = "90";
        Configuration.clickViaJs = true;
        Configuration.baseUrl = "";
        Configuration.browserCapabilities.setCapability("enableVNC", false);
        Configuration.browserCapabilities.setCapability("enableVideo", false);
        if (!globalModeDebug) {
            Configuration.remote = "http://localhost:4444/wd/hub";
        } else {
            Configuration.timeout = 20000;
        }
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
        CustomLogger.logger.info("ok");
    }

    public void setUpConfigFirefox() {
        FirefoxOptions options = new FirefoxOptions();
        options.addPreference("dom.webnotifications.enabled", false);
        Configuration.browserCapabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
        Configuration.startMaximized = true;
        Configuration.pageLoadStrategy = "eager";
        Configuration.downloadsFolder = "target/build/downloads";
        Configuration.reportsFolder = "target/screenshots";
        Configuration.pageLoadTimeout = 10000;
        Configuration.timeout = 10000;
        Configuration.browser = "Firefox";
      //  Configuration.browserVersion = "89";
        Configuration.clickViaJs = true;
        Configuration.baseUrl = "";
        Configuration.browserCapabilities.setCapability("enableVNC", false);
        Configuration.browserCapabilities.setCapability("enableVideo", false);
        if (!globalModeDebug) {
            Configuration.remote = "http://localhost:4444/wd/hub";
        } else {
            Configuration.timeout = 20000;
        }
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
        CustomLogger.logger.info("ok");
    }

}

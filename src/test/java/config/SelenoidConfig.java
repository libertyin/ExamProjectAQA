package config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import logger.CustomLogger;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

import static global.Global.*;

public class SelenoidConfig {

    public void setUpConfig() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);
        if (globalIsMobileDevice) {
            Map<String, String> mobileEmulation = new HashMap<>();
            mobileEmulation.put("deviceName", "Nexus 5");
            options.setExperimentalOption("mobileEmulation", mobileEmulation);
            globalDevice = "Mobile";
        } else {
            globalDevice = "Desktop";
            Configuration.startMaximized = true;
        }
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
//        if (!globalModeDebug) {
//            Configuration.remote = "http://localhost:4444/wd/hub";
//        } else {
//            Configuration.timeout = 20000;
//        }
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
        CustomLogger.logger.info("ok");
    }

}

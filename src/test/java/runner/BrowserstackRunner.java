package runner;

import config.BrowserstackConfig;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.Logs;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.WebDriverRunner.driver;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static pages.actions.general.CommonSteps.writeLog;

public class BrowserstackRunner {
    @BeforeMethod
    public void setUp() throws Exception {
        BrowserstackConfig browserstackConfig = new BrowserstackConfig();
        browserstackConfig.setUpConfigBrowserstack();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownAfterMethod() {
        if (driver().hasWebDriverStarted() && driver().browser().isChrome()) {
            Logs logs = getWebDriver().manage().logs();
            writeLog(logs.get(LogType.BROWSER), "BrowserConsoleLog");
        }
    }
}

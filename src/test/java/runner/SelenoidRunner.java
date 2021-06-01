package runner;

import config.SelenoidConfig;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.Logs;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.WebDriverRunner.driver;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static pages.actions.general.CommonSteps.writeLog;

public class SelenoidRunner {

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        SelenoidConfig selenoidConfig = new SelenoidConfig();
        selenoidConfig.setUpConfig();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownAfterMethod() {
        if (driver().hasWebDriverStarted() && driver().browser().isChrome()) {
            Logs logs = getWebDriver().manage().logs();
            writeLog(logs.get(LogType.BROWSER), "BrowserConsoleLog");
        }
    }

}

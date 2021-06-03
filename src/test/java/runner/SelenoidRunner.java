package runner;

import config.SelenoidConfig;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.Logs;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import static com.codeborne.selenide.WebDriverRunner.driver;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static pages.actions.general.CommonSteps.writeLog;

public class SelenoidRunner {

    @Parameters({"browserName"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(String browserName) {
        SelenoidConfig selenoidConfig = new SelenoidConfig();
        if(browserName.equalsIgnoreCase("firefox")){
            selenoidConfig.setUpConfigFirefox();
        }else{
            selenoidConfig.setUpConfigChrome();
        }
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownAfterMethod() {
        if (driver().hasWebDriverStarted() && driver().browser().isChrome()) {
            Logs logs = getWebDriver().manage().logs();
            writeLog(logs.get(LogType.BROWSER), "BrowserConsoleLog");
        }
    }

}

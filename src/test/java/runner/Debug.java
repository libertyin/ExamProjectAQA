package runner;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeMethod;

public class Debug {

    @BeforeMethod
    public void setUp() {
        Configuration.timeout = 10000;
        Configuration.reportsFolder = "target/screenshots";
        Configuration.downloadsFolder = "target/build/downloads";
        Configuration.browser = "chrome";
        Configuration.browserVersion = "90";
        Configuration.startMaximized = true;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

}


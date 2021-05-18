package pages.actions.general;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import logger.CustomLogger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.testng.Assert;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.url;

public class CommonSteps {
    static SelenideElement bodyOfPageWithIP = $(byXpath("//body"));

    @Step
    public static void checkGeoLocation(String country) {
        String[] response;
        String countryCode = null;
        for (int i = 0; i < 20; i++) {
            open("https://api.myip.com/");
            response = bodyOfPageWithIP.getText().split(":");
            if (response.length >= 4) {
                countryCode = response[3].replaceAll("\"", "").replaceAll("}", "");
                break;
            } else {
                sleep(500);
            }
        }
        if (countryCode != null && countryCode.equals(country)) {
            getAndAttachScreenshot();
            CustomLogger.logger.info("Test geolocation by ip passed: " + countryCode + " equals " + country + "\n" +
                    bodyOfPageWithIP.getText());
        } else {
            getAndAttachScreenshot();
            if (country != null && !country.equals("")) {
                Assert.fail("Test geolocation by ip failed: " + countryCode + " not equals " + country + "\n" +
                        bodyOfPageWithIP.getText());
            } else {
                CustomLogger.logger.info(bodyOfPageWithIP.getText());
            }
        }
    }

    @Step
    public static void assertEqualsWithWait(SelenideElement element, String var2, int waitSec) {
        element.shouldBe(Condition.visible);
        boolean condition = false;
        String var1 = "";
        for (int i = 0; i < (waitSec * 2); i++) {
            var1 = element.getText();
            condition = var1.equals(var2);
            if (condition) {
                break;
            } else {
                sleep(500);
            }
        }
        getAndAttachScreenshot();
        if (!condition) {
            Assert.fail(var1 + " not equals " + var2);
        }
    }

    @Step
    public static void checkUrl(String mustContains) {
        boolean conditionForUrl = false;
        for (int i = 0; i < 60; i++) {
            if (url().contains(mustContains)) {
                conditionForUrl = true;
                getAndAttachScreenshot();
                break;
            } else {
                sleep(500);
            }
        }
        if (!conditionForUrl) {
            getAndAttachScreenshot();
            Assert.fail("Actual URL: " + url() + "\n" + "Expected URL: " + mustContains);
        }
    }

    @Step
    public static void checkUrl(String mustContains, int timeOutSec) {
        boolean testPassed = false;
        for (int i = 0; i < timeOutSec * 2; i++) {
            if (url().contains(mustContains)) {
                testPassed = true;
                getAndAttachScreenshot();
                break;
            } else {
                sleep(500);
            }
        }
        if (!testPassed) {
            getAndAttachScreenshot();
            Assert.fail("Actual URL: " + url() + "\n" + "Expected URL: " + mustContains);
        }
    }

    @Step
    public static void checkUrlWithOr(String mustContains, String or, int timeOutSec) {
        boolean conditionForUrl = false;
        for (int i = 0; i < timeOutSec * 2; i++) {
            if (url().contains(mustContains)) {
                conditionForUrl = true;
                getAndAttachScreenshot();
                break;
            } else if (url().contains(or)) {
                conditionForUrl = true;
                getAndAttachScreenshot();
                break;
            } else {
                sleep(500);
            }
        }
        if (!conditionForUrl) {
            getAndAttachScreenshot();
            Assert.fail("Actual URL: " + url() + "\n" + "Expected URL: " + mustContains);
        }
    }

    @Step
    public static void checkElementAndClickItWithOutAssert(SelenideElement element, int waitSec) {
        for (int i = 0; i < (waitSec * 2); i++) {
            if (!element.isDisplayed()) {
                sleep(500);
            } else {
                element.click();
                break;
            }
        }
    }

    @Step
    public static boolean elementIsExistWithWait(SelenideElement element, int waitSec) {
        for (int i = 0; i < (waitSec * 2); i++) {
            if (!element.exists()) {
                sleep(500);
            } else {
                return true;
            }
        }
        return false;
    }

    @Step
    public static boolean elementIsDisplayedWithWait(SelenideElement element, int waitSec) {
        for (int i = 0; i < (waitSec * 2); i++) {
            if (!element.isDisplayed()) {
                sleep(500);
            } else {
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings("UnusedReturnValue")
    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] getAndAttachScreenshot() {
        return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @SuppressWarnings("UnusedReturnValue")
    @Attachment(value = "log", type = "application/json")
    public static byte[] attachToAllureReportWithTypeJSON(String resourceName) throws IOException {
        return Files.readAllBytes(Paths.get("target/", resourceName));
    }

    @SuppressWarnings("UnusedReturnValue")
    @Attachment
    public static byte[] attachToAllureReport(String resourceName) throws IOException {
        return Files.readAllBytes(Paths.get("target/", resourceName));
    }

    public static void writeLog(LogEntries entries, String logName) {
        try {
            File browserConsoleLog = new File("target//" + logName + ".txt");
            if (browserConsoleLog.exists()) {
                //noinspection ResultOfMethodCallIgnored
                browserConsoleLog.delete();
            }
            FileWriter writer = new FileWriter("target//" + logName + ".txt", true);
            for (LogEntry entry : entries) {
                Date date = new Date(entry.getTimestamp());
                SimpleDateFormat ft = new SimpleDateFormat("HH:mm:ss");
                if (logName.contains("Performance")) {
                    String message = entry.getMessage();
                    if (message.contains("\"status\":\"5") || message.contains("\"status\":\"4")) {
                        writer.write(ft.format(date) + " " + entry.getLevel() + " " + entry.getMessage() +
                                "\r\n\n");
                    }
                } else {
                    writer.write(ft.format(date) + " " + entry.getLevel() + " " + entry.getMessage() + "\r\n\n");
                }
            }
            writer.close();
            if (logName.contains("Performance")) {
                attachToAllureReportWithTypeJSON(logName + ".txt");
            } else {
                attachToAllureReport(logName + ".txt");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

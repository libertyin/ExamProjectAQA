package tests;

import com.codeborne.selenide.Selenide;
import data.ProjectUrls;
import data.Users;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BaseItPlatform;
import utils.ExcelWorker;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;
import static global.Global.*;


public class RegisterTests extends BaseItPlatform {
    ExcelWorker excelWorker = new ExcelWorker();
    String excelFilePath = "src/test/java/data/Users.xls";

    @BeforeClass
    public void prepareExelFile() throws IOException {
        File file = new File(excelFilePath);
        if (!file.exists() && !file.isDirectory()) {
            String[] headers = new String[]{"firstName", "secondName", "email", "password"};
            excelWorker.prepareExcelFile(excelFilePath, headers);
        }
    }

    @BeforeMethod
    public void openProjectPage() {
        open(ProjectUrls.IT_PLATFORM_WEBSITE.getUrl());
    }

    @Test
    public void checkRegisterHappyPass() {
        mainPage.clickMenuLink(ProjectUrls.MENU_SIGN_IN.getUrl());
        signInPage.clickRegistrationLink();
        registerPage.fillNameWithTempName();
        registerPage.fillEmailWithTempEmail();
        registerPage.fillPassword(Users.USER_REGISTERED.getPassword());
        registerPage.fillRepeatPassword(Users.USER_REGISTERED.getPassword());
        registerPage.clickRegisterButton();
        mainPage.checkMyProfileLink();

        // TODO remove and use close web driver after method
//        mainPage.exitProfile();

        //write to excel file registered users
        Object[] allData = new Object[]{globalFirstName, globalSecondName, globalEmail,
                Users.USER_REGISTERED.getPassword()};
        excelWorker.writeToExistingExcelFile(excelFilePath, allData);
    }

    @Test
    public void checkRegisterEmptyWarnings() {
        mainPage.clickMenuLink(ProjectUrls.MENU_SIGN_IN.getUrl());
        signInPage.clickRegistrationLink();
        registerPage.clickRegisterButton();
        registerPage.checkWarningEmptyName();
        registerPage.checkWarningEmptyEmail();
        registerPage.checkWarningEmptyPassword();
    }

    @Test
    public void checkRegisterErrorWarnings() {
        mainPage.clickMenuLink(ProjectUrls.MENU_SIGN_IN.getUrl());
        signInPage.clickRegistrationLink();
        registerPage.fillName(Users.USER_NEGATIVE.getFirstName(), Users.USER_NEGATIVE.getLastName());
        registerPage.fillEmail(Users.USER_NEGATIVE.getEmail());
        registerPage.fillPassword(Users.USER_NEGATIVE.getPassword());
        registerPage.fillRepeatPassword(Users.USER_REGISTERED.getPassword());
        registerPage.clickRegisterButton();
        registerPage.checkWarningEmailWrongAddress();
        registerPage.checkWarningPasswordDoNotMatch();
    }

    //the user with such email is already exist
    @Test
    public void checkRegisterSameEmail() {
        mainPage.clickMenuLink(ProjectUrls.MENU_SIGN_IN.getUrl());
        signInPage.clickRegistrationLink();
        registerPage.fillName(Users.USER_REGISTERED.getFirstName(), Users.USER_REGISTERED.getLastName());
        registerPage.fillEmail(Users.USER_REGISTERED.getEmail());
        registerPage.fillPassword(Users.USER_REGISTERED.getPassword());
        registerPage.fillRepeatPassword(Users.USER_REGISTERED.getPassword());
        registerPage.clickRegisterButton();
        registerPage.checkWarningSameEmail();
    }

    @AfterClass
    public void closeBrowser() {
        Selenide.closeWebDriver();
    }
}

package tests;

import com.codeborne.selenide.Selenide;
import data.ProjectUrls;
import data.Users;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BaseItPlatform;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class RegisterTests extends BaseItPlatform {
    @BeforeMethod
    public void openProjectPage() {
        open(ProjectUrls.IT_PLATFORM_WEBSITE.getUrl());
    }

    @Test (groups = "Registration:positive", priority = 0)
    public void checkRegisterHappyPass() {
       mainPage.clickMenuLink(ProjectUrls.MENU_SIGN_IN.getUrl());
       signInPage.clickRegistrationLink();
       registerPage.fillName(Users.USER_POSITIVE.getFirstName(), Users.USER_POSITIVE.getLastName());
       registerPage.fillEmail(Users.USER_POSITIVE.getEmail());
       registerPage.fillPassword(Users.USER_POSITIVE.getPassword());
       registerPage.fillRepeatPassword(Users.USER_POSITIVE.getPassword());
       registerPage.clickRegisterButton();
       mainPage.checkMyProfileLink();
    }

    @Test(groups = "Registration:negative")
    public void checkRegisterEmptyWarnings(){
        mainPage.clickMenuLink(ProjectUrls.MENU_SIGN_IN.getUrl());
        signInPage.clickRegistrationLink();
        registerPage.clickRegisterButton();
        registerPage.checkWarningEmptyName();
        registerPage.checkWarningEmptyEmail();
        registerPage.checkWarningEmptyPassword();
    }

    @Test(groups = "Registration:negative")
    public void checkRegisterErrorWarnings(){
        mainPage.clickMenuLink(ProjectUrls.MENU_SIGN_IN.getUrl());
        signInPage.clickRegistrationLink();
        registerPage.fillName(Users.USER_NEGATIVE.getFirstName(), Users.USER_NEGATIVE.getLastName());
        registerPage.fillEmail(Users.USER_NEGATIVE.getEmail());
        registerPage.fillPassword(Users.USER_NEGATIVE.getPassword());
        registerPage.fillRepeatPassword(Users.USER_POSITIVE.getPassword());
        registerPage.clickRegisterButton();
        registerPage.checkWarningEmailWrongAddress();
        registerPage.checkWarningPasswordDoNotMatch();
    }

    @Test(groups = "Registration:negative")
    public void checkRegisterSameEmail(){
        mainPage.clickMenuLink(ProjectUrls.MENU_SIGN_IN.getUrl());
        signInPage.clickRegistrationLink();
        registerPage.fillName(Users.USER_POSITIVE.getFirstName(), Users.USER_POSITIVE.getLastName());
        registerPage.fillEmail(Users.USER_POSITIVE.getEmail());
        registerPage.fillPassword(Users.USER_POSITIVE.getPassword());
        registerPage.fillRepeatPassword(Users.USER_POSITIVE.getPassword());
        registerPage.clickRegisterButton();
        registerPage.checkWarningSameEmail();
    }

    @AfterMethod
    public void closeBrowser() {
        Selenide.closeWebDriver();
    }
}

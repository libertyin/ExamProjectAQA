package tests;

import com.codeborne.selenide.Selenide;
import data.ProjectUrls;
import data.Users;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BaseItPlatform;

import static com.codeborne.selenide.Selenide.open;

public class SignInTests extends BaseItPlatform {

    @BeforeMethod
    public void openProjectPage() {
        open(ProjectUrls.IT_PLATFORM_WEBSITE.getUrl());
    }

    @Test
    public void checkSignInHappyPass() {
        mainPage.clickMenuLink(ProjectUrls.MENU_SIGN_IN.getUrl());
        signInPage.fillEmail(Users.USER_REGISTERED.getEmail());
        signInPage.fillPassword(Users.USER_REGISTERED.getPassword());
        signInPage.clickSignIn();
        mainPage.checkMyProfileLink();
    }

    @Test
    public void checkSignInEmptyWarnings() {
        mainPage.clickMenuLink(ProjectUrls.MENU_SIGN_IN.getUrl());
        signInPage.clickSignIn();
        signInPage.checkWarningEmptyName();
        signInPage.checkWarningEmptyPassword();
    }

    @Test
    public void checkUnknownNameWarnings() {
        mainPage.clickMenuLink(ProjectUrls.MENU_SIGN_IN.getUrl());
        signInPage.fillEmail(Users.USER_NEGATIVE.getEmail());
        signInPage.fillPassword(Users.USER_NEGATIVE.getPassword());
        signInPage.clickSignIn();
        signInPage.checkWarningUnknownName();
    }

    @AfterClass
    public void closeBrowser() {
        Selenide.closeWebDriver();
    }

}

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

public class SignInTests extends BaseItPlatform {
    @BeforeMethod
    public void openProjectPage() {
        open(ProjectUrls.IT_PLATFORM_WEBSITE.getUrl());
    }

    @Test (groups = "SignIn:positive")
    public void checkSignInHappyPass() {
        mainPage.clickMenuLink(ProjectUrls.MENU_SIGN_IN.getUrl());
        signInPage.fillEmail(Users.USER_POSITIVE.getEmail());
        signInPage.fillPassword(Users.USER_POSITIVE.getPassword());
        signInPage.clickSignIn();
        mainPage.checkMyProfileLink();
    }

    @Test (groups = "SignIn:negative")
    public void checkSignInEmptyWarnings() {
        mainPage.clickMenuLink(ProjectUrls.MENU_SIGN_IN.getUrl());
        signInPage.clickSignIn();
        signInPage.checkWarningEmptyName();
        signInPage.checkWarningEmptyPassword();
    }

    @Test (groups = "SignIn:negative")
    public void checkUnknownNameWarnings() {
        mainPage.clickMenuLink(ProjectUrls.MENU_SIGN_IN.getUrl());
        signInPage.fillEmail(Users.USER_NEGATIVE.getEmail());
        signInPage.fillPassword(Users.USER_NEGATIVE.getPassword());
        signInPage.clickSignIn();
        signInPage.checkWarningUnknownName();
    }

    @AfterMethod
    public void closeBrowser() {
        Selenide.closeWebDriver();
    }

}

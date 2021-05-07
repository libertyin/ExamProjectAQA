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

    @Test
    public void checkSignInHappyPass() {
        mainPage.clickSignInLink();
        signInPage.fillEmail(Users.USER_1.getEmail());
        signInPage.fillPassword(Users.USER_1.getPassword());
        signInPage.clickSignIn();
        mainPage.checkMyProfileLink();
        sleep(100000);
    }
    @AfterMethod
    public void closeBrowser() {
        Selenide.closeWebDriver();
    }

}

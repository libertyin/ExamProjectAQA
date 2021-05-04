package tests;

import com.codeborne.selenide.Selenide;
import data.ProjectUrls;
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
        mainPage.clickSignIn();
        signInPage.fillEmail();
        signInPage.fillPassword();
    }

    @AfterMethod
    public void closeBrowser() {
        Selenide.closeWebDriver();
    }
}

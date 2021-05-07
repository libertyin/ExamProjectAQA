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

    @Test
    public void checkRegisterHappyPass() {
       mainPage.clickSignInLink();
       signInPage.clickRegistrationLink();
       registerPage.fillName(Users.USER_1.getFirstName(), Users.USER_1.getLastName());
       registerPage.fillEmail(Users.USER_1.getEmail());
       registerPage.fillPassword(Users.USER_1.getPassword());
       registerPage.fillRepeatPassword(Users.USER_1.getPassword());
       registerPage.clickRegisterButton();
       mainPage.checkMyProfileLink();
       sleep(100);
    }

    @AfterMethod
    public void closeBrowser() {
        Selenide.closeWebDriver();
    }
}

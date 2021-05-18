package tests;

import com.codeborne.selenide.Selenide;
import data.ProjectUrls;
import data.Users;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BaseItPlatform;

import static com.codeborne.selenide.Selenide.back;
import static com.codeborne.selenide.Selenide.open;

public class MainPageTests extends BaseItPlatform {

    @BeforeMethod
    public void openProjectPage() {
        open(ProjectUrls.IT_PLATFORM_WEBSITE.getUrl());
    }

    @Test
    public void checkMenuBrokenLinks() {
        mainPage.clickMenuLink(ProjectUrls.MENU_YOUR_OBJECTIVE.getUrl());
        commonSteps.checkUrl(ProjectUrls.MENU_YOUR_OBJECTIVE.getUrl());
        back();
        mainPage.clickMenuLink(ProjectUrls.MENU_ACHIEVE_YOUR_GOAL.getUrl());
        commonSteps.checkUrl(ProjectUrls.MENU_ACHIEVE_YOUR_GOAL.getUrl());
        back();
        mainPage.clickMenuLink(ProjectUrls.MENU_CHOOSE_YOUR_PACK.getUrl());
        commonSteps.checkUrl(ProjectUrls.MENU_CHOOSE_YOUR_PACK.getUrl());
        back();
        mainPage.clickMenuLink(ProjectUrls.MENU_PRICING.getUrl());
        commonSteps.checkUrl(ProjectUrls.MENU_PRICING.getUrl());
        back();
        mainPage.clickMenuLink(ProjectUrls.MENU_SIGN_IN.getUrl());
        commonSteps.checkUrl(ProjectUrls.MENU_SIGN_IN.getUrl());
    }

    @AfterMethod
    public void closeBrowser() {
        Selenide.closeWebDriver();
    }
}

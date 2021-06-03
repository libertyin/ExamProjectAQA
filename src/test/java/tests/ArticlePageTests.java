package tests;

import com.codeborne.selenide.Selenide;
import data.ProjectUrls;
import data.Users;
import org.testng.annotations.*;
import pages.BaseItPlatform;

import static com.codeborne.selenide.Selenide.open;

public class ArticlePageTests extends BaseItPlatform {

    @BeforeMethod
    public void openProjectPage() {
        open(ProjectUrls.IT_PLATFORM_WEBSITE.getUrl());
    }

    //Comments tests
    @Test
    void checkCommentsHappyPass() {
        mainPage.clickTheFirstPost();
        articlePage.fillCommentAreaWithTempComment();
        articlePage.fillName(Users.USER_REGISTERED.getFirstName());
        articlePage.fillEmail(Users.USER_REGISTERED.getEmail());
        articlePage.fillUrl(ProjectUrls.RANDOM_URL.getUrl());
        articlePage.clickSubmitComment();
        articlePage.checkCommentModeration();
    }

    @Test
    void checkCommentsFillError() {
        mainPage.clickTheFirstPost();
        articlePage.clickSubmitComment();
        articlePage.checkForCommentFillError();
    }

    @Test
    void checkCommentsEmailError() {
        mainPage.clickTheFirstPost();
        articlePage.fillCommentAreaWithTempComment();
        articlePage.fillName(Users.USER_REGISTERED.getFirstName());
        articlePage.fillEmail(Users.USER_NEGATIVE.getEmail());
        articlePage.clickSubmitComment();
        articlePage.checkForCommentIncorrectEmailError();
    }

    //Recent Posts tests
    @Test
    public void checkRecentPostTitle() {
        articlePage.checkRecentPostTitle(5);
    }

    @Test
    public void checkRecentPostHasElements() {
        articlePage.clickAnyRecentPost(5);
        articlePage.checkArticleImg();
        articlePage.checkArticleTitle();
        articlePage.checkArticleMeta();
        articlePage.checkArticleContent();
    }

    @AfterClass
    public void closeBrowser() {
        Selenide.closeWebDriver();
    }
}

package pages.actions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import logger.CustomLogger;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import pages.locators.ArticlePageLocators;

import java.util.Random;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static global.Global.globalRandomLetters;
import static pages.actions.general.CommonSteps.getAndAttachScreenshot;

public class ArticlePage extends ArticlePageLocators {

    @Step("Fill comment area field")
    public void fillCommentAreaWithTempComment() {
        globalRandomLetters = RandomStringUtils.randomAlphabetic(10);
        commentArea.sendKeys("Hello world " + globalRandomLetters);
        CustomLogger.logger.info("ok");
    }

    @Step("Fill name field")
    public void fillName(String name) {
        inputName.sendKeys(name);
        CustomLogger.logger.info("ok");
    }

    @Step("Fill email field")
    public void fillEmail(String email) {
        inputEmail.sendKeys(email);
        CustomLogger.logger.info("ok");
    }

    @Step("Fill url field")
    public void fillUrl(String url) {
        inputUrl.sendKeys(url);
        CustomLogger.logger.info("ok");
    }

    @Step("Click submit comment")
    public void clickSubmitComment() {
        buttonCommentsSubmit.click();
        CustomLogger.logger.info("ok");
    }

    @Step("Check comment is added to the post")
    public void checkCommentModeration() {
        commentModeration.shouldBe(Condition.visible);
        getAndAttachScreenshot();
        CustomLogger.logger.info("ok");
    }

    @Step("Check for comment fill error to be present")
    public void checkForCommentFillError() {
        errorCommentsFillNameEmail.shouldBe(Condition.visible);
        CustomLogger.logger.info("ok");
    }

    @Step("Check for comment incorrect Email error to be present")
    public void checkForCommentIncorrectEmailError() {
        errorCommentsIncorrectEmail.shouldBe(Condition.visible);
        CustomLogger.logger.info("ok");
    }

    //recent posts
    @Step("Check title in all Recent posts equals")
    public void checkRecentPostTitle(int numberOfRecentPosts) {
        String resentPostsLinkText;
        String resentPostsTitle;
        for (int i = 1; i <= numberOfRecentPosts; i++) {
            resentPostsLinkText = $(byXpath(prepareResentPost + "[" + i + "]/a")).text();
            SelenideElement resentPost = $(byXpath(prepareResentPost + "[" + i + "]/a"));
            resentPost.click();
            resentPostsTitle = $(byXpath(prepareArticleTitle)).text();
            if (!(resentPostsLinkText.equals(resentPostsTitle))) {
                getAndAttachScreenshot();
                Assert.fail("\nActual title of resent post: " + resentPostsTitle + "\n" +
                        "Expected title of resent post: " + resentPostsTitle);
            } else {
                CustomLogger.logger.info("ok");
            }
        }
    }

    @Step("Click any of resent posts")
    public void clickAnyRecentPost(int numberOfRecentPosts) {
        Random rand = new Random();
        int randomPost = rand.nextInt(numberOfRecentPosts) + 1;
        SelenideElement resentPost = $(byXpath(prepareResentPost + "[" + randomPost + "]/a"));
        resentPost.click();
        CustomLogger.logger.info("ok");
    }

    @Step("Check article image is exist")
    public void checkArticleImg() {
        articleImage.shouldBe(Condition.visible);
        CustomLogger.logger.info("ok");
    }

    @Step("Check article title is exist")
    public void checkArticleTitle() {
        articleTitle.shouldBe(Condition.visible);
        CustomLogger.logger.info("ok");
    }

    @Step("Check article meta is exist")
    public void checkArticleMeta() {
        articleMeta.shouldBe(Condition.visible);
        CustomLogger.logger.info("ok");
    }

    @Step("Check article content is exist")
    public void checkArticleContent() {
        articleContent.shouldBe(Condition.visible);
        CustomLogger.logger.info("ok");
    }
}

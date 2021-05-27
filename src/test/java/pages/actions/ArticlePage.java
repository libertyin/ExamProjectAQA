package pages.actions;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import logger.CustomLogger;
import org.apache.commons.lang3.RandomStringUtils;
import pages.locators.ArticlePageLocators;

import static global.Global.globalRandomLetters;

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
    public void clickSubmitComment(){
        buttonCommentsSubmit.click();
        CustomLogger.logger.info("ok");
    }

    @Step("Check comment is added to the post")
    public void checkCommentModeration(){
        commentModeration.shouldBe(Condition.visible);
        CustomLogger.logger.info("ok");
    }

    @Step("Check for comment fill error to be present")
    public void checkForCommentFillError(){
        errorCommentsFillNameEmail.shouldBe(Condition.visible);
        CustomLogger.logger.info("ok");
    }

    @Step("Check for comment incorrect Email error to be present")
    public void checkForCommentIncorrectEmailError(){
        errorCommentsIncorrectEmail.shouldBe(Condition.visible);
        CustomLogger.logger.info("ok");
    }
}

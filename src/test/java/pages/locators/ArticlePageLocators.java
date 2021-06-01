package pages.locators;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ArticlePageLocators {
    //resent post locators
    public String prepareResentPost = "//div[@id=\"recent-posts-2\"]//ul//li";
    public String prepareArticleTitle = "//header/h2[@class=\"single-post-title entry-title\"]";
    public SelenideElement articleImage = $(byXpath("//div[@class=\"thumbnail\"]/img"));
    public SelenideElement articleTitle = $(byXpath("//header/h2[@class=\"single-post-title entry-title\"]"));
    public SelenideElement articleMeta = $(byXpath("//ul[@class=\"meta ospm-default clr\"]"));
    public SelenideElement articleContent = $(byXpath("//div[@class=\"entry-content clr\"]/p"));

    //comments
    public SelenideElement commentArea = $(byXpath("//textarea[@name=\"comment\"]"));
    public SelenideElement inputName = $(byXpath("//input[@name=\"author\"]"));
    public SelenideElement inputEmail = $(byXpath("//input[@name=\"email\"]"));
    public SelenideElement inputUrl = $(byXpath("//input[@name=\"url\"]"));
    public SelenideElement buttonCommentsSubmit = $(byXpath("//input[@type=\"submit\"]"));
    public SelenideElement errorCommentsIncorrectEmail = $(byXpath("//p[text()=\": пожалуйста, введите корректный адрес email.\"]"));
    public SelenideElement errorCommentsFillNameEmail = $(byXpath("//p[text()=\": пожалуйста, заполните необходимые поля (имя, email).\"]"));
    public SelenideElement commentModeration = $(byXpath("//p[@class=\"comment-awaiting-moderation\"]"));
}

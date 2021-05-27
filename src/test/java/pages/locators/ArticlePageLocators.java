package pages.locators;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ArticlePageLocators {
    //comments
    public SelenideElement commentArea = $(byXpath("//textarea[@name=\"comment\"]"));
    public SelenideElement inputName = $(byXpath("//input[@name=\"author\"]"));
    public SelenideElement inputEmail = $(byXpath("//input[@name=\"email\"]"));
    public SelenideElement inputUrl = $(byXpath("//input[@name=\"url\"]"));
    public SelenideElement saveCheckbox = $(byXpath("//input[@name=\"wp-comment-cookies-consent\"]"));
    public SelenideElement buttonCommentsSubmit = $(byXpath("//input[@type=\"submit\"]"));
    public SelenideElement errorCommentsIncorrectEmail = $(byXpath("//p[text()=\": пожалуйста, введите корректный адрес email.\"]"));
    public SelenideElement errorCommentsFillNameEmail = $(byXpath("//p[text()=\": пожалуйста, заполните необходимые поля (имя, email).\"]"));
    public SelenideElement commentModeration = $(byXpath("//p[@class=\"comment-awaiting-moderation\"]"));
}

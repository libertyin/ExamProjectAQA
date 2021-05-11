package pages.locators;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class SignInPageLocators {

    //SignIn fields
    public SelenideElement inputEmail = $(byXpath("//input[@id='user_login']"));
    public SelenideElement inputPassword = $(byXpath("//input[@id='user_pass']"));
    public SelenideElement buttonSignIn = $(byXpath("//button[@class='tml-button']"));
    public SelenideElement linkRegistration = $(byXpath("//a[@href='https://it-platforma.website/register/']"));

    //SignIn empty fields warnings
    public SelenideElement nameEmptyWarning = $(byXpath("//li[@class=\"tml-error\" and text()=\": Вы не ввели имя пользователя.\"] "));
    public SelenideElement passwordEmptyWarning = $(byXpath("//li[@class=\"tml-error\" and text()=\": Вы не ввели пароль.\"]"));

    //SignIn error warnings
    public SelenideElement nameUnknownWarning = $(byXpath("//li[@class=\"tml-error\" and text()=\"Неизвестное имя пользователя. Перепроверьте или попробуйте ваш адрес email.\"] "));

}

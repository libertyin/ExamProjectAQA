package pages.locators;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class SignInPageLocators {
    public SelenideElement inputEmail = $(byXpath("//input[@id='user_login']"));
    public SelenideElement inputPassword = $(byXpath("//input[@id='user_pass']"));
    public SelenideElement buttonSignIn = $(byXpath("//button[@class='tml-button']"));
}

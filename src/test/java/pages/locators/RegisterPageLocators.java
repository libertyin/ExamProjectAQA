package pages.locators;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class RegisterPageLocators {
    public SelenideElement inputName = $(byXpath("//input[@id=\"user_login\"]"));
    public SelenideElement inputEmail = $(byXpath("//input[@id=\"user_email\"]"));
    public SelenideElement inputPassword = $(byXpath("//input[@id=\"pass1\"]"));
    public SelenideElement inputRepeatPassword = $(byXpath("//input[@id=\"pass2\"]"));
    public SelenideElement buttonRegister = $(byXpath("//button[@class=\"tml-button\"]"));

}

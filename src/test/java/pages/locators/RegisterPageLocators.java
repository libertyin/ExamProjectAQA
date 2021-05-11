package pages.locators;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class RegisterPageLocators {
    //Register fields
    public SelenideElement inputName = $(byXpath("//input[@id=\"user_login\"]"));
    public SelenideElement inputEmail = $(byXpath("//input[@id=\"user_email\"]"));
    public SelenideElement inputPassword = $(byXpath("//input[@id=\"pass1\"]"));
    public SelenideElement inputRepeatPassword = $(byXpath("//input[@id=\"pass2\"]"));
    public SelenideElement buttonRegister = $(byXpath("//button[@class=\"tml-button\"]"));

    //Register empty fields warnings
    public SelenideElement nameEmptyWarning = $(byXpath("//li[@class=\"tml-error\" and text()=\": Пожалуйста, введите имя пользователя.\"] "));
    public SelenideElement emailEmptyWarning = $(byXpath("//li[@class=\"tml-error\" and text()=\": Пожалуйста, введите ваш адрес email.\"]"));
    public SelenideElement passwordEmptyWarning = $(byXpath("//li[@class=\"tml-error\" and text()=\": Please enter a password.\"]"));

    //Register error warnings
    public SelenideElement passwordDoNotMatchWarning = $(byXpath("//li[@class=\"tml-error\" and text()=\": Passwords don’t match. Please enter the same password in both password fields.\"]"));
    public SelenideElement emailWrongAddressWarning = $(byXpath("//li[@class=\"tml-error\" and text()=\": Некорректный адрес email.\"]"));
    public SelenideElement emailSameAddressWarning = $(byXpath("//li[@class=\"tml-error\" and text()=\": Это имя пользователя уже зарегистрировано. Пожалуйста, выберите другое.\"]"));

}

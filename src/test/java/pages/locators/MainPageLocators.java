package pages.locators;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MainPageLocators {
    public SelenideElement buttonSignIn = $(byXpath("//span[text()='Sign in']"));

}

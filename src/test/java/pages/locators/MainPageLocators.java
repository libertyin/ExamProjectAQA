package pages.locators;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MainPageLocators {

    public SelenideElement linkMyProfile = $(byXpath("//a[@href='https://it-platforma.website/wp-admin/profile.php']"));
    public SelenideElement searchField = $(byXpath("//input[@type=\"search\"]"));

    public String prepareLinkLocator = "//a[@href='";
    //resent post
    public String prepareResentPost = "//div[@id=\"recent-posts-2\"]//ul//li";


}

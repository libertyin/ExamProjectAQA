package pages.locators;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MainPageLocators {

    public SelenideElement linkMyProfile = $(byXpath("//a[@href='https://it-platforma.website/wp-admin/profile.php']"));
    public SelenideElement searchField = $(byXpath("//input[@type=\"search\"]"));

    public String prepareLinkLocator = "//a[@href='";

    //first resent post
    public SelenideElement firstPost = $(byXpath("//div[@id=\"right-sidebar-inner\"]//li[1]/a"));

    //search
    public String searchResults = "//div[@id=\"content\"]/article ";
    public String prepareXPathSearchResult = "//div[@id=\"content\"]/article[";
    public SelenideElement searchResultsNotFound = $(byXpath("//div[@class=\"page-content\"]/p"));

}

package pages.locators;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MainPageLocators {

    public SelenideElement linkMyProfile = $(byXpath("//a[@href='https://it-platforma.website/wp-admin/profile.php']"));
    public String prepareLinkLocator = "//a[@href='";


}

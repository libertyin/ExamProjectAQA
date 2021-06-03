package tests;

import com.codeborne.selenide.Selenide;
import data.ProjectUrls;
import org.testng.annotations.*;
import pages.BaseItPlatform;

import static com.codeborne.selenide.Selenide.open;
import static pages.actions.general.CommonSteps.checkUrl;

public class MainPageTests extends BaseItPlatform {

    @BeforeMethod
    public void openProjectPage() {
        open(ProjectUrls.IT_PLATFORM_WEBSITE.getUrl());
    }

    //link tests
    @DataProvider
    public Object[][] menuLinksProvider() {
        return new Object[][]{
                {"https://5element.ua/"}, {"https://5element.ua/about/special_offer/"}, {"https://5element.ua/shedule/"},
                {"https://5element.ua/klubnye-karty/"}, {"https://it-platforma.website/login/"}
        };
    }

    @Test(dataProvider = "menuLinksProvider")
    public void checkMenuBrokenLinks(String link) {
        mainPage.clickMenuLink(link);
        checkUrl(link);
    }

    //search Tests
    @Test
    void checkSearchHappyPass() {
        mainPage.fillSearch("Litera");
        mainPage.submitSearch();
        mainPage.checkForSearchResultsExist("Litera");
    }

    @Test
    void checkSearchWithNegativeData() {
        mainPage.fillSearch("qwerty");
        mainPage.submitSearch();
        mainPage.checkForSearchResultsNotExist("qwerty");
    }


    @AfterClass
    public void closeBrowser() {
        Selenide.closeWebDriver();
    }
}

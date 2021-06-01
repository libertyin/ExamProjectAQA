package pages.actions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import logger.CustomLogger;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import pages.locators.MainPageLocators;

import java.util.ArrayList;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static pages.actions.general.CommonSteps.getAndAttachScreenshot;

public class MainPage extends MainPageLocators {
    ArrayList<String> arrayList = new ArrayList<>();

    @Step("Check for Profile link to exist")
    public void checkMyProfileLink() {
        linkMyProfile.shouldBe(Condition.visible);
        CustomLogger.logger.info("ok");
    }

    //menu
    @Step("Click the menu link")
    public void clickMenuLink(String linkHref) {
        $(byXpath(prepareLinkLocator + linkHref + "']")).click();
        CustomLogger.logger.info("ok");
    }

    //search
    @Step("Fill Search field")
    public void fillSearch(String searchRequest){
        searchField.sendKeys(searchRequest);
        CustomLogger.logger.info("ok");
    }

    @Step("Click submit in Search field")
    public void submitSearch(){
        searchField.sendKeys(Keys.ENTER);
        CustomLogger.logger.info("ok");
    }

    @Step("Check for search results")
    public void checkForSearchResultsExist(String searchRequest) {
        int xpathCount = $$(byXpath(searchResults)).size();
        ArrayList<String> arrayList = new ArrayList<>();
        if (xpathCount > 0) {
            for (int i = 1; i < xpathCount+1; i++)
                arrayList.add($(byXpath(prepareXPathSearchResult + i + "]//a[@title]")).text());
        }
        boolean searchResultContains = true;
        for (int i = 0; i < arrayList.size(); i++) {
            searchResultContains = arrayList.get(i).contains(searchRequest);
            if (!searchResultContains){
                getAndAttachScreenshot();
                Assert.fail("\nActual search result: " + arrayList.get(i) + "\n" + "Expected search result: " + searchRequest);
            }else {
                CustomLogger.logger.info("ok");
            }
        }
    }

    @Step("Check for search results")
    public void checkForSearchResultsNotExist(String searchRequest) {
        searchResultsNotFound.shouldBe(Condition.visible);
        CustomLogger.logger.info("ok");
    }

    //comments
    @Step("Click the first post")
    public void clickTheFirstPost(){
        firstPost.click();
        CustomLogger.logger.info("ok");
    }

}



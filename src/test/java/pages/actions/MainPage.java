package pages.actions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import logger.CustomLogger;
import org.openqa.selenium.Keys;
import pages.locators.MainPageLocators;

import java.util.ArrayList;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

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
    @Step("Click submit in Search field")
    public void submitSearch(){
        searchField.sendKeys(Keys.ENTER);
    }

    //recent posts
    @Step("Calculate the Recent posts")
    public void clickRecentPost() {
        int xpathCount = $$(byXpath(prepareResentPost)).size();
        if (xpathCount > 0) {
            for (int i = 1; i < xpathCount+1; i++) {
                arrayList.add(prepareResentPost + "[" + i + "]");
            }
        }
    }
}


